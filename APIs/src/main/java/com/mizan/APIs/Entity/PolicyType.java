package com.mizan.APIs.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "policy_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "External ID is required")
    private Integer externalId;

    @NotBlank(message = "Policy name is required")
    private String name;


    @NotBlank(message = "Policy number is required")
    @Pattern(regexp = "^[A-Z0-9-]+$", message = "Policy number must contain only uppercase letters, numbers, or dashes")
    private String policyNo;

    @NotNull(message = "Start date is required")
    @PastOrPresent(message = "Start date cannot be in the future")
    private LocalDate startDate;


    @NotNull(message = "Expiry date is required")
    @Future(message = "Expiry date must be in the future")
    private LocalDate expiryDate;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private PolicyDepartment policyDepartment;



}
