package com.shahab.university_api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "modules")
@Data
public class Module {
    @Id
    private String moduleId;

    private String title;

    @ElementCollection
    private List<String> topics;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Assessment> assessments;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}