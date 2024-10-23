package com.Job_Portal.Job.Dekho.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "jobs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(length = 5000)
    private String description;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    private JobType jobType; //Full time, Part time,

    @Column(nullable = false)
    private String salaryRange;

    @Column(nullable = false)
    private String industry;

    @Column(nullable = false)
    private String qualifications;

    @Column(nullable = false)
    private int minExperience;

    @Column(nullable = false)
    private int maxExperience;

    @Column(nullable = false)
    private LocalDate applicationDeadline;

    @Column
    private String benefits; // Additional benefits (e.g., health insurance, work-from-home option)

    @Column(nullable = false)
    private boolean remoteAllowed = false; // Whether remote work is allowed

    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    private User employer; // Reference to the employer who posted the job


    public enum JobType {
        FULL_TIME, PART_TIME, CONTRACT, INTERN, TEMPORARY
    }
}
