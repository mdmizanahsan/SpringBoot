package com.mizan.user_dashboard_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Builder
public class Comment {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    private String message;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
