package com.mizan.authify.service;

import com.mizan.authify.io.ProfileRequest;
import com.mizan.authify.io.ProfileResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService {
    ProfileResponse createProfile(ProfileRequest request);
}
