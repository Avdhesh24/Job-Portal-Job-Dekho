package com.Job_Portal.Job.Dekho.controller;

import com.Job_Portal.Job.Dekho.model.Job;
import com.Job_Portal.Job.Dekho.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    // Create a new job
    @PostMapping("/create")
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job createdJob = jobService.createJob(job);
        return ResponseEntity.ok(createdJob);
    }

    // Update an existing job by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable int id, @RequestBody Job updatedJob) {
        Job job = jobService.updateJob(id, updatedJob);
        if (job != null) {
            return ResponseEntity.ok(job);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a job by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok("Job deleted successfully.");
    }

    // Get a list of all jobs
    @GetMapping("/all")
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    // Get a job by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable int id) {
        Job job = jobService.getJobById(id);
        if (job != null) {
            return ResponseEntity.ok(job);
        }
        return ResponseEntity.notFound().build();
    }
}
