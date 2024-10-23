package com.Job_Portal.Job.Dekho.serviceImpl;

import com.Job_Portal.Job.Dekho.model.Job;
import com.Job_Portal.Job.Dekho.repository.JobRepository;
import com.Job_Portal.Job.Dekho.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(int jobId, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(jobId);
        if (jobOptional.isPresent()) {
            Job existingJob = jobOptional.get();

            existingJob.setTitle(updatedJob.getTitle());
            existingJob.setDescription(updatedJob.getDescription());
            existingJob.setCompanyName(updatedJob.getCompanyName());
            existingJob.setLocation(updatedJob.getLocation());
            existingJob.setJobType(updatedJob.getJobType());
            existingJob.setSalaryRange(updatedJob.getSalaryRange());
            existingJob.setIndustry(updatedJob.getIndustry());
            existingJob.setQualifications(updatedJob.getQualifications());
            existingJob.setMinExperience(updatedJob.getMinExperience());
            existingJob.setMaxExperience(updatedJob.getMaxExperience());
            existingJob.setApplicationDeadline(updatedJob.getApplicationDeadline());
            existingJob.setBenefits(updatedJob.getBenefits());
            existingJob.setRemoteAllowed(updatedJob.isRemoteAllowed());

            return jobRepository.save(existingJob);
        }
        return null;
    }

    @Override
    public void deleteJob(int jobId) {
        if (jobRepository.existsById(jobId)) {
            jobRepository.deleteById(jobId);
        }
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> getJobsByEmployerId(int employerId) {
        return jobRepository.findByEmployerId((long) employerId);
    }

    @Override
    public Job getJobById(int jobId) {
        Optional<Job> jobOptional = jobRepository.findById(jobId);
        return jobOptional.orElse(null);
    }
}
