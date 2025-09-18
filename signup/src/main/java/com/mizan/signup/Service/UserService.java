package com.mizan.signup.Service;


import com.mizan.signup.Dto.SignupRequest;
import com.mizan.signup.Dto.SignupResponse;

public interface UserService {
    SignupResponse registerUser(SignupRequest request);
}
