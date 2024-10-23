package com.Job_Portal.Job.Dekho.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private User jobSeeker; // The user receiving the notification

    private String message; // Notification message
    private LocalDateTime timestamp; // When the notification was created

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    public enum NotificationType {
        APPLICATION_STATUS_UPDATE,
        NEW_JOB_POSTING
    }
}


