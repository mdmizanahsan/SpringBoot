package com.mizan.user_dashboard_api.entity;

import com.mizan.user_dashboard_api.domains.NotificarionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notification_tbl")
@Builder
public class Notification {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;
    @Enumerated(EnumType.STRING)
    private NotificarionType type;

    private String message;

    @Column(name = "is_read")
    private Boolean read;


    @Column(name = "time_stamp")
    @com.fasterxml.jackson.annotation.JsonProperty("timestamp")
    private LocalDateTime timeStamp;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void prePersist() {
        if (this.id == null || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
        if (this.timeStamp == null) {
            this.timeStamp = LocalDateTime.now();
        }
    }
}
