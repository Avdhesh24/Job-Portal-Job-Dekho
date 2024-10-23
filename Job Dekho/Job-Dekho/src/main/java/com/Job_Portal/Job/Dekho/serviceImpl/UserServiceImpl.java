package com.Job_Portal.Job.Dekho.serviceImpl;

import com.Job_Portal.Job.Dekho.model.User;
import com.Job_Portal.Job.Dekho.repository.UserRepository;
import com.Job_Portal.Job.Dekho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (Objects.isNull(user.getRole())) {
            user.setRole(User.Role.JOB_SEEKER);
        }
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
