package com.shahab.university_api.entity.embedded;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.LocalDate;

@Embeddable
@Data
public class Semester {
    private String code;
    private LocalDate startDate;
    private LocalDate endDate;
}
