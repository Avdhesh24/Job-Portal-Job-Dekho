package com.Job_Portal.Job.Dekho.repository;

import com.Job_Portal.Job.Dekho.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
