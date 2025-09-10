package com.mizan.PolicyLLM.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.List;

@Entity
@Table(name = "policy_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary Key

    @OneToMany
    @JoinColumn(name = "policy_id")
    private List coverages;

    @OneToMany
    @JoinColumn(name = "policy_id")
    private List summaries;
}
