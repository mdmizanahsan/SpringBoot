package com.mizan.PolicyLLM.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tax_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxDetails {

    @Column(name = "percentage", nullable = false)
    private double percentage;

    @Column(name = "amount", nullable = false)
    private double amount;
}
