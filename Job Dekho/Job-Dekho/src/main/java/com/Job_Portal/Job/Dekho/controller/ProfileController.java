package com.Job_Portal.Job.Dekho.controller;

import com.Job_Portal.Job.Dekho.model.Profile;
import com.Job_Portal.Job.Dekho.model.User;
import com.Job_Portal.Job.Dekho.service.ProfileService;
import com.Job_Portal.Job.Dekho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createProfile(@RequestBody Profile profile, Authentication authentication) {
        try {
            // Get authenticated user and set as job seeker for profile
            String username = authentication.getName();
            User user = userService.findByUsername(username);

            if (user != null) {
                profile.setJobSeeker(user);
                profileService.createProfile(profile);
                return ResponseEntity.ok("Profile created successfully for user: " + profile.getFullName());
            } else {
                return ResponseEntity.badRequest().body("Invalid user.");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Profile creation failed: " + e.getMessage());
        }
    }

    @PutMapping("/{profileId}")
    public ResponseEntity<String> updateProfile(@PathVariable int profileId, @RequestBody Profile profile) {
        try {
            Profile updatedProfile = profileService.updateProfile(profileId, profile);
            if (updatedProfile != null) {
                return ResponseEntity.ok("Profile updated successfully.");
            } else {
                return ResponseEntity.badRequest().body("Profile not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Profile update failed: " + e.getMessage());
        }
    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<String> deleteProfile(@PathVariable int profileId) {
        try {
            profileService.deleteProfile(profileId);
            return ResponseEntity.ok("Profile deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Profile deletion failed: " + e.getMessage());
        }
    }

    @GetMapping("/job-seeker/{jobSeekerId}")
    public ResponseEntity<Profile> getProfileByJobSeekerId(@PathVariable int jobSeekerId) {
        Profile profile = profileService.getProfileByJobSeekerId(jobSeekerId);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }
}
