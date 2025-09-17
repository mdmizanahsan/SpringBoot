package com.shahab.university_api.entity;

import com.shahab.university_api.entity.embedded.Profile;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    private String userId;

    private String username;
    private String email;
    private String password; 

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles;

    private String status; 

    @Embedded
    private Profile profile;

    @ElementCollection
    @CollectionTable(name = "user_permissions", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "permission")
    private Set<String> permissions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LoginHistory> loginHistory;

    private Instant lastLogin;
    private int failedAttempts;
    private boolean twoFaEnabled;
    private String provider;
}