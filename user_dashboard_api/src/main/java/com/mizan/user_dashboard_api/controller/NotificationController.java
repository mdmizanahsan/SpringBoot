package com.mizan.user_dashboard_api.controller;

import com.mizan.user_dashboard_api.entity.Notification;
import com.mizan.user_dashboard_api.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

      private final NotificationService notificationService;

    @PostMapping("/{userId}")
    public ResponseEntity<Notification> create(@PathVariable String userId , @RequestBody Notification notification) {
          try {
             Notification created = notificationService.create(userId, notification);
             return new ResponseEntity<>(created, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
          }
      }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> getByUser(@PathVariable String userId) {
        try {
            List<Notification> notifications = notificationService.getByUser(userId);
            if (notifications != null && !notifications.isEmpty()) {
                return new ResponseEntity<>(notifications, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PatchMapping("/{notificationId}/read")
    public ResponseEntity<Notification> markAsRead(@PathVariable String notificationId) {
        try {
            Notification updated = notificationService.markAsRead(notificationId);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
