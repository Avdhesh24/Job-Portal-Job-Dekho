package com.Job_Portal.Job.Dekho.service;


import com.Job_Portal.Job.Dekho.model.Profile;

import java.util.List;

public interface ProfileService {


    Profile createProfile(Profile profile);


    Profile updateProfile(int profileId, Profile profile);


    void deleteProfile(int profileId);


    Profile getProfileByJobSeekerId(int jobSeekerId);


    List<Profile> getAllProfiles();
}

