package com.mizan.PolicyLLM.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coverage")
public class Coverage {


    @Id  // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serialNo;

    @Column(name = "coverage_type", nullable = false)
    private String coverageType;

    @Column(name = "sum_insured")
    private double sumInsured;

    @Column(name = "premium")
    private double premium;

    @Column(name = "currency")
    private String currency;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private PolicyDetails policyDetails;
}
