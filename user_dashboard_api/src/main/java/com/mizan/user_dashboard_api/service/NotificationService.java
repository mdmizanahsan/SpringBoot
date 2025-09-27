package com.mizan.user_dashboard_api.service;

import com.mizan.user_dashboard_api.entity.Notification;

import java.util.List;

public interface NotificationService {
    Notification create(String userId , Notification notification);
    List<Notification> getByUser(String userId);
    Notification markAsRead(String notificationId);
}
