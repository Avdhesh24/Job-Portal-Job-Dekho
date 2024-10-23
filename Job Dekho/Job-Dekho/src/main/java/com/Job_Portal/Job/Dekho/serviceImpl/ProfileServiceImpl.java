package com.Job_Portal.Job.Dekho.serviceImpl;

import com.Job_Portal.Job.Dekho.model.Profile;
import com.Job_Portal.Job.Dekho.repository.ProfileRepository;
import com.Job_Portal.Job.Dekho.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(int profileId, Profile profile) {
        // Fetch the existing profile by ID
        Optional<Profile> existingProfile = profileRepository.findById(profileId);
        if (existingProfile.isPresent()) {
            Profile updatedProfile = existingProfile.get();


            updatedProfile.setFullName(profile.getFullName());
            updatedProfile.setPhone(profile.getPhone());
            updatedProfile.setEducation(profile.getEducation());
            updatedProfile.setExperience(profile.getExperience());
            updatedProfile.setCurrentCity(profile.getCurrentCity());
            updatedProfile.setDateOfBirth(profile.getDateOfBirth());
            updatedProfile.setSkills(profile.getSkills());
            updatedProfile.setResumeLink(profile.getResumeLink());
            updatedProfile.setLinkedInProfile(profile.getLinkedInProfile());
            updatedProfile.setGithubProfile(profile.getGithubProfile());
            updatedProfile.setLanguages(profile.getLanguages());
            updatedProfile.setNoticePeriod(profile.getNoticePeriod());
            updatedProfile.setPreferredLocation(profile.getPreferredLocation());
            updatedProfile.setExpectedSalary(profile.getExpectedSalary());
            updatedProfile.setJobPreferences(profile.getJobPreferences());
            updatedProfile.setProjects(profile.getProjects());

            return profileRepository.save(updatedProfile);
        }
        return null;
    }

    @Override
    public void deleteProfile(int profileId) {
        if (profileRepository.existsById(profileId)) {
            profileRepository.deleteById(profileId);
        }
    }

    @Override
    public Profile getProfileByJobSeekerId(int jobSeekerId) {
        // Fetch the profile based on the jobSeekerId
        return profileRepository.findByJobSeekerId(jobSeekerId);
    }

    @Override
    public List<Profile> getAllProfiles() {
        // Return all profiles from the database
        return profileRepository.findAll();
    }
}
