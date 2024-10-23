package com.Job_Portal.Job.Dekho.serviceImpl;

import com.Job_Portal.Job.Dekho.model.Application;
import com.Job_Portal.Job.Dekho.repository.ApplicationRepository;
import com.Job_Portal.Job.Dekho.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Application applyForJob(Application application) {
        // Save the application to the database
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getApplicationsByJobSeeker(int jobSeekerId) {
        return applicationRepository.findByJobSeekerId(jobSeekerId);
    }

    @Override
    public List<Application> getApplicationsByJob(int jobId) {
        // Find all applications for a job
        return applicationRepository.findByJobId(jobId);
    }

    @Override
    public Application updateApplicationStatus(int applicationId, Application.ApplicationStatus status) {
        // Update the status of the application
        Optional<Application> application = applicationRepository.findById(applicationId);
        if (application.isPresent()) {
            Application updatedApplication = application.get();
            updatedApplication.setStatus(status);
            return applicationRepository.save(updatedApplication);
        }
        return null;
    }
}
