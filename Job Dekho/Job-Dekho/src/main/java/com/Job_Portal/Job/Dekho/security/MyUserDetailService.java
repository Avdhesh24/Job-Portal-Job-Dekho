package com.Job_Portal.Job.Dekho.security;

import com.Job_Portal.Job.Dekho.model.User;
import com.Job_Portal.Job.Dekho.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user  = userRepository.findByUsername(username);

        if(user == null)
        {
            throw new UsernameNotFoundException("user not found with this email : "+username);
        }

        return new MyUserDetails(user);
    }
}
