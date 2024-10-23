package com.Job_Portal.Job.Dekho.repository;

import com.Job_Portal.Job.Dekho.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {

    Profile findByJobSeekerId(int jobSeekerId);
}
