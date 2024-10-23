package com.Job_Portal.Job.Dekho.controller;

import com.Job_Portal.Job.Dekho.model.Application;
import com.Job_Portal.Job.Dekho.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Apply for a job
    @PostMapping("/apply")
    public ResponseEntity<Application> applyForJob(@RequestBody Application application) {
        Application savedApplication = applicationService.applyForJob(application);
        return ResponseEntity.ok(savedApplication);
    }

    // Get applications by job seeker ID
    @GetMapping("/jobSeeker/{jobSeekerId}")
    public ResponseEntity<List<Application>> getApplicationsByJobSeeker(@PathVariable int jobSeekerId) {
        List<Application> applications = applicationService.getApplicationsByJobSeeker(jobSeekerId);
        return ResponseEntity.ok(applications);
    }

    // Get applications by job ID
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Application>> getApplicationsByJob(@PathVariable int jobId) {
        List<Application> applications = applicationService.getApplicationsByJob(jobId);
        return ResponseEntity.ok(applications);
    }

    // Update application status
    @PutMapping("/updateStatus/{applicationId}")
    public ResponseEntity<Application> updateApplicationStatus(@PathVariable int applicationId, @RequestParam Application.ApplicationStatus status) {
        Application updatedApplication = applicationService.updateApplicationStatus(applicationId, status);
        if (updatedApplication != null) {
            return ResponseEntity.ok(updatedApplication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
