package com.mizan.PolicyLLM.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "summary")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "total_sum_insured")
    private double totalSumInsured;

    @Column(name = "base_premium")
    private double basePremium;

    @Column(name = "stamp_duty")
    private double stampDuty;

    @Column(name = "policy_fee")
    private double policyFee;

    @Column(name = "premium_payable")
    private double premiumPayable;

    @Column(name = "policy_excess")
    private double policyExcess;

    @Column(name = "currency")
    private String currency;

    @Column(name = "premium_remark")
    private String premiumRemark;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private PolicyDetails policyDetails;

    @Embedded
    private TaxDetails localTax;

    @Embedded
    private TaxDetails tax;
}
