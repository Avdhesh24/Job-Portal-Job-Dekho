package com.Job_Portal.Job.Dekho.serviceImpl;

import com.Job_Portal.Job.Dekho.model.Notification;
import com.Job_Portal.Job.Dekho.model.User;
import com.Job_Portal.Job.Dekho.repository.NotificationRepository;
import com.Job_Portal.Job.Dekho.repository.UserRepository;
import com.Job_Portal.Job.Dekho.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Notification createNotification(Notification notification) {
        notification.setTimestamp(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotificationsByJobSeekerId(int jobSeekerId) {
        Optional<User> jobSeeker = userRepository.findById(jobSeekerId);
        if (jobSeeker.isPresent()) {
            return notificationRepository.findByJobSeeker(jobSeeker.get());
        }
        return List.of();
    }

    @Override
    public void deleteNotification(int notificationId) {
        if (notificationRepository.existsById(notificationId)) {
            notificationRepository.deleteById(notificationId);
        }
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
