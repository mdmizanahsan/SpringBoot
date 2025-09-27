package com.mizan.user_dashboard_api.entity;


import com.mizan.user_dashboard_api.domains.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_tbl")
@Builder
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    private String name;
    private String email;
    private String profileImage;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private LocalDateTime joinedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications;

    @PrePersist
    public void prePersist() {
        if (this.id == null || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
        if (this.joinedAt == null) {
            this.joinedAt = LocalDateTime.now();
        }
        // For each notification, set user, id, and timestamp if not set
        if (this.notifications != null) {
            this.notifications.forEach(notification -> {
                notification.setUser(this);
                if (notification.getId() == null || notification.getId().isEmpty()) {
                    notification.setId(UUID.randomUUID().toString());
                }
                if (notification.getTimeStamp() == null) {
                    notification.setTimeStamp(LocalDateTime.now());
                }
            });
        }
    }

}
