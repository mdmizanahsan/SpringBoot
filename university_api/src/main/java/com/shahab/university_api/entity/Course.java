package com.shahab.university_api.entity;

import com.shahab.university_api.entity.embedded.GradingPolicy;
import com.shahab.university_api.entity.embedded.Semester;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "courses")
@Data
public class Course {
    @Id
    private String courseId;

    private String title;
    private String departmentId;
    private String instructorId;
    private String description;
    private int credits;
    private int capacity;
    private int enrolled;

    @ElementCollection
    private List<String> waitlist;

    @Embedded
    private Semester semester;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Module> modules;

    @Embedded
    private GradingPolicy gradingPolicy;
}