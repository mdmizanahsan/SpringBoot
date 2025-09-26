package com.mizan.user_dashboard_api.repository;

import com.mizan.user_dashboard_api.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,String> {
}
