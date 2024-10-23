package com.Job_Portal.Job.Dekho.repository;

import com.Job_Portal.Job.Dekho.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {
    List<Job> findByEmployerId(Long employerId);
}
