package com.mizan.user_dashboard_api.entity;


import com.mizan.user_dashboard_api.entity.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Builder
public class User {

    @Id
    private String id;

    private String name;
    private String email;
    private String profileIamge;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private Instant joinedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications;

    @ManyToMany(mappedBy = "members")
    private List<Team> teams;

}
