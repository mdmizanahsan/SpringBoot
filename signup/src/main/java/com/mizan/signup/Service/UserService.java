package com.mizan.signup.Service;


import com.mizan.signup.Dto.LoginRequest;
import com.mizan.signup.Dto.LoginResponse;
import com.mizan.signup.Dto.SignupRequest;
import com.mizan.signup.Dto.SignupResponse;

public interface UserService {
    SignupResponse registerUser(SignupRequest request);
    LoginResponse login(LoginRequest request);
}
