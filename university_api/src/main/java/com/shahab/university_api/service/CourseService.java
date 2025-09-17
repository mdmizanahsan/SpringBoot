package com.shahab.university_api.service;

import com.shahab.university_api.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course saveCourse(Course course);
    Course findById(String id);
    void deleteCourse(String id);
    boolean enrollUser(String courseId, String userId);
}