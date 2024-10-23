package com.Job_Portal.Job.Dekho.service;

import com.Job_Portal.Job.Dekho.model.Notification;

import java.util.List;

public interface NotificationService {


    Notification createNotification(Notification notification);

    List<Notification> getNotificationsByJobSeekerId(int jobSeekerId);


    void deleteNotification(int notificationId);


    List<Notification> getAllNotifications();
}
