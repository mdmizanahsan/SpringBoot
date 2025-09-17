package com.shahab.university_api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "login_history")
@Data
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;
    private String ip;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}