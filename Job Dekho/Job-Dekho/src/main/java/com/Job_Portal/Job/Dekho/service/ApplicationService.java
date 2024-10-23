package com.Job_Portal.Job.Dekho.service;

import com.Job_Portal.Job.Dekho.model.Application;

import java.util.List;

public interface ApplicationService {

    Application applyForJob(Application application);

    List<Application> getApplicationsByJobSeeker(int jobSeekerId);

    List<Application> getApplicationsByJob(int jobId);  // Get all applications for a specific job

    Application updateApplicationStatus(int applicationId, Application.ApplicationStatus status);  // Update application status
}
