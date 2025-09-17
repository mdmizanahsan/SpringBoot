package com.shahab.university_api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Data
public class AuditLog {
    @Id
    private String actionId;

    private String actionType;
    private String performedBy;
    private String courseId;
    private LocalDateTime timestamp;
    private String status;
}