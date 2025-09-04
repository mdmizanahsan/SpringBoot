package com.mizan.syphar.service;

import com.mizan.syphar.io.ProfileRequest;
import com.mizan.syphar.io.ProfileResponse;

public interface ProfileService {


   ProfileResponse createProfile(ProfileRequest request);
}
