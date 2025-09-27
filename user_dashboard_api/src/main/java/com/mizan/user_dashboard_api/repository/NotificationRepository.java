package com.mizan.user_dashboard_api.repository;

import com.mizan.user_dashboard_api.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,String> {
    List<Notification> findByuserId(String userId);
}
