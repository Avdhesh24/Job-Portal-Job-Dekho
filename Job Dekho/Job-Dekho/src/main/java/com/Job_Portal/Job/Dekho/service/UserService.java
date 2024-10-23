package com.Job_Portal.Job.Dekho.service;

import com.Job_Portal.Job.Dekho.model.User;

public interface UserService {

    User registerUser(User user);

    User findByUsername(String username);
}
