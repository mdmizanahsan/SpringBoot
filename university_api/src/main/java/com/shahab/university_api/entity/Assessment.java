package com.shahab.university_api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "assessments")
@Data
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int weight;
    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;
}