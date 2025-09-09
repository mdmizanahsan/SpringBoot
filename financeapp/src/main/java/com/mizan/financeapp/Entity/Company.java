package com.mizan.financeapp.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company")
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Address is mandatory")
    private String address;

    private String phoneNumber;
    private String mobileNumber;
    private String customerGroupName;
    private String industrySegment;
    private String omangNumber;
    private String country;
    private String city;
    private String poBoxOrZip;
    private String organizationType;
    private String contactName;
    private String designation;
    private String email;
    private String website;
    private LocalDate dateOfBirth;
    private LocalDate anniversaryDate;
}
