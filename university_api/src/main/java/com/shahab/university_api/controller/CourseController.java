package com.shahab.university_api.controller;

import com.shahab.university_api.dto.CourseDto;
import com.shahab.university_api.entity.Course;
import com.shahab.university_api.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR', 'STUDENT')")
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<CourseDto> courses = courseService.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(courses);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody Course course) {
        Course savedCourse = courseService.saveCourse(course);
        return ResponseEntity.ok(mapToDto(savedCourse));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR', 'STUDENT')")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable String id) {
        Course course = courseService.findById(id);
        return course != null ? ResponseEntity.ok(mapToDto(course)) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable String id, @Valid @RequestBody Course course) {
        Course existingCourse = courseService.findById(id);
        if (existingCourse == null) {
            return ResponseEntity.notFound().build();
        }
        course.setCourseId(id); // Ensure ID remains same
        Course updatedCourse = courseService.saveCourse(course);
        return ResponseEntity.ok(mapToDto(updatedCourse));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        Course course = courseService.findById(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/enroll/{courseId}/{userId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
    public ResponseEntity<String> enrollUser(@PathVariable String courseId, @PathVariable String userId) {
        boolean enrolled = courseService.enrollUser(courseId, userId);
        if (enrolled) {
            return ResponseEntity.ok("User " + userId + " enrolled in course " + courseId);
        } else {
            return ResponseEntity.badRequest().body("User " + userId + " added to waitlist for course " + courseId + " due to full capacity");
        }
    }

    private CourseDto mapToDto(Course course) {
        CourseDto dto = new CourseDto();
        dto.setCourseId(course.getCourseId());
        dto.setTitle(course.getTitle());
        dto.setDepartmentId(course.getDepartmentId());
        dto.setInstructorId(course.getInstructorId());
        dto.setDescription(course.getDescription());
        dto.setCredits(course.getCredits());
        return dto;
    }
}