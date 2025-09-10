package com.mizan.PolicyLLM.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "claim")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "claim_id")
    private String claimId;

    @Column(name = "claim_number")
    private String claimNumber;

    @Column(name = "claim_date")
    private String date;

    @Column(name = "claim_description")
    private String description;

    @Column(name = "claim_remarks")
    private String remarks;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "contact_email" ,unique = true ,nullable = false)
    private String email;
}
