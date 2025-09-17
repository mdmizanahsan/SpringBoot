
package com.shahab.university_api.service;

import com.shahab.university_api.entity.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> findAll();
    List<Notification> findByUserId(String userId);
    Notification saveNotification(Notification notification);
    Notification markAsRead(String id);
}
