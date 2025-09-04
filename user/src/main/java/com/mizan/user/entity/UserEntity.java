package com.mizan.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String username;

    private String fullName;

    @Column(unique = true,nullable = false)
    private String email;

    private String password;

    @Transient
    private String confirmPassword;


    private String bio;
    private String phoneNumber;
    private Boolean isAuthenticated = false;
    private String avatarUrl;

    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;

    @ElementCollection
    private List<String> hobbies ;
}
