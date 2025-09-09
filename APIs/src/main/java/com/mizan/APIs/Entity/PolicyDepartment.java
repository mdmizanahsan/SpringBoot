package com.mizan.APIs.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "policy_departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "policyDepartment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PolicyType> policyTypes;
}
