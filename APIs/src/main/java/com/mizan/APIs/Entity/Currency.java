package com.mizan.APIs.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "currenies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Currency code is required")
    private String code;

    @NotBlank(message = "Currency name is required")
    private String name;

    @NotNull(message = "Conversion rate is required")
    @Positive(message = "Conversion rate must be greater than 0")
    private Double conversionRate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
