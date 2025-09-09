package com.mizan.APIs.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "policy_summary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicySummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sumInsured;
    private String premium;
    private Double localTaxPercentage;
    private String localTaxAmount;
    private Double taxPercentage;
    private String taxAmount;
    private String stampDuty;
    private String policyFee;
    private String premiumPayable;
    private String policyExcess;
    private String projectName;
    private String premiumRemark;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private PolicyParticularsAndPremiumDetails parent;

}
