package com.mizan.user_dashboard_api.entity;

import com.mizan.user_dashboard_api.entity.enums.NotificarionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Builder
public class Notification {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private NotificarionType type;

    private String message;

    private Boolean read;

    private Instant timestamp;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
