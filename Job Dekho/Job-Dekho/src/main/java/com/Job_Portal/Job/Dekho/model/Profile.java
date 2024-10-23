package com.Job_Portal.Job.Dekho.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;
    private String phone;
    private String education;
    private String experience;
    private String currentCity;
    private LocalDate dateOfBirth;
    private String skills;
    private String resumeLink;
    private String linkedInProfile;
    private String githubProfile;
    private String languages;
    private String noticePeriod;
    private String preferredLocation;
    private String expectedSalary;
    private String jobPreferences;
    private String projects;

    @OneToOne
    @JoinColumn(name = "job_seeker_id")
    private User jobSeeker;
}
