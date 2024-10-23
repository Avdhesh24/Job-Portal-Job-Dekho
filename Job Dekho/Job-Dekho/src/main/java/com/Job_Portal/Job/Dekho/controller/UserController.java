package com.Job_Portal.Job.Dekho.controller;

import com.Job_Portal.Job.Dekho.model.User;
import com.Job_Portal.Job.Dekho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        // Check if the role is JOB_SEEKER and create a Profile if needed
        if (user.getRole() == User.Role.JOB_SEEKER && user.getProfile() == null) {
            return ResponseEntity.badRequest().body(null); // Invalid request
        }

        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(Authentication authentication) {
        try {
            User user = userService.findByUsername(authentication.getName());
            return ResponseEntity.ok("Login successful for user: " + user.getUsername());
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}


//    @GetMapping("/find/{username}")
//    public ResponseEntity<User> findByUsername(@PathVariable("username") String username) {
//        User user = userService.findByUsername(username);
//        if (user != null) {
//            return ResponseEntity.ok(user);
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }

