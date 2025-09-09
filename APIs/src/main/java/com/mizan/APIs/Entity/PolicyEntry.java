package com.mizan.APIs.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "policy_entries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyEntry {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Serial number (sno) is required")
    @Positive(message = "Serial number must be positive")
    private Integer sno;

    @NotBlank(message = "Coverage is required")
    private String coverage;

    private String sumInsured;

    private String location;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private PolicyParticularsAndPremiumDetails parent;
}
