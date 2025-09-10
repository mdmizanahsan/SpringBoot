package com.mizan.PolicyLLM.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "other_notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtherNotes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note", nullable = false, length = 500)
    private String note;

    @Column(name = "is_compliant")
    private boolean isCompliant;

    @ManyToOne
    @JoinColumn(name = "extended_policy_id")
    private ExtendedPolicyDetails extendedPolicyDetails;
}
