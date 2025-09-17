package com.shahab.university_api.service.impl;

import com.shahab.university_api.entity.Course;
import com.shahab.university_api.repository.CourseRepository;
import com.shahab.university_api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course findById(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    @Override
    public boolean enrollUser(String courseId, String userId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            return false;
        }
        if (course.getEnrolled() < course.getCapacity()) {
            course.setEnrolled(course.getEnrolled() + 1);
            courseRepository.save(course);
            return true; 
        } else {
            List<String> waitlist = course.getWaitlist();
            if (!waitlist.contains(userId)) {
                waitlist.add(userId);
                course.setWaitlist(waitlist);
                courseRepository.save(course);
            }
            return false; 
        }
    }
}
