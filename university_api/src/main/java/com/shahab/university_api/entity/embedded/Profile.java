package com.shahab.university_api.entity.embedded;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Embeddable
@Data
public class Profile {
    private String fullName;
    private String departmentId;
    private String departmentName;
    private String hod;
    private List<String> qualifications;
    private int experienceYears;
    private List<String> specializations;
    private List<String> officeDays;
    private String officeTime;
    private String officeLocation;
    private String studentId;
    private String batch;
    private String major;
    private int currentSemester;
    private String academicStanding;
    private double gpa;
    private int completedCredits;

    @ElementCollection
    private List<CourseTranscript> courses;
}

@Embeddable
@Data
class CourseTranscript {
    private String courseId;
    private String title;
    private String grade;
    private int credit;
    private String completedOn;
}