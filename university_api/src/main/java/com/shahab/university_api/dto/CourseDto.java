package com.shahab.university_api.dto;

import lombok.Data;

@Data
public class CourseDto {
    private String courseId;
    private String title;
    private String departmentId;
    private String instructorId;
    private String description;
    private int credits;
}
