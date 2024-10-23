package com.Job_Portal.Job.Dekho.service;

import com.Job_Portal.Job.Dekho.model.Job;

import java.util.List;

public interface JobService {


        Job createJob(Job job);

        Job updateJob(int jobId, Job job);

        void deleteJob(int jobId);

        List<Job> getAllJobs();

        List<Job> getJobsByEmployerId(int employerId);

        Job getJobById(int jobId);
    }


