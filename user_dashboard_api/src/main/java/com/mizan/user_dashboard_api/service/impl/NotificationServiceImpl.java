package com.mizan.user_dashboard_api.service.impl;

import com.mizan.user_dashboard_api.entity.Notification;
import com.mizan.user_dashboard_api.entity.User;
import com.mizan.user_dashboard_api.repository.NotificationRepository;
import com.mizan.user_dashboard_api.repository.UserRepository;
import com.mizan.user_dashboard_api.service.NotificationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    public Notification create( String userId ,Notification notification) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
       notification.setUser(user);
        notification.setTimeStamp(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    public List<Notification> getByUser(String userId) {
        return notificationRepository.findByuserId(userId);
    }

    public Notification markAsRead(String notificationId) {
        Notification notification= notificationRepository.findById(notificationId)
                .orElseThrow( () -> new RuntimeException("Notification not found"));
        notification.setRead(true);
        return notificationRepository.save(notification);
    }
}
