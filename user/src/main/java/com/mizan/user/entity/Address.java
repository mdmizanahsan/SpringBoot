package com.mizan.user.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Embeddable
public class Address {

    private String state;
    private String district;
    private int pincode;
    private String area;
}
