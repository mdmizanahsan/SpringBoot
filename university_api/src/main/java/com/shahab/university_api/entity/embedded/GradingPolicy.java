package com.shahab.university_api.entity.embedded;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class GradingPolicy {
    private int midterm;
    private int finalExam;
    private int assignments;
    private int attendance;
    private int participation;
}