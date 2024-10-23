package com.Job_Portal.Job.Dekho.repository;

import com.Job_Portal.Job.Dekho.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    List<Application> findByJobSeekerId(int jobSeekerId);

    List<Application> findByJobId(int jobId);
}
