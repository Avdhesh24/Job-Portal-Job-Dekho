package com.Job_Portal.Job.Dekho.controller;

import com.Job_Portal.Job.Dekho.model.Notification;
import com.Job_Portal.Job.Dekho.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Create a new notification
    @PostMapping("/create")
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification createdNotification = notificationService.createNotification(notification);
        return ResponseEntity.ok(createdNotification);
    }

    // Get notifications by job seeker ID
    @GetMapping("/jobSeeker/{jobSeekerId}")
    public ResponseEntity<List<Notification>> getNotificationsByJobSeekerId(@PathVariable int jobSeekerId) {
        List<Notification> notifications = notificationService.getNotificationsByJobSeekerId(jobSeekerId);
        return ResponseEntity.ok(notifications);
    }

    // Get all notifications
    @GetMapping("/all")
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    // Delete a notification by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable int id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.ok("Notification deleted successfully.");
    }
}
