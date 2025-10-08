package com.mizan.jwtauth.controller;

import com.mizan.jwtauth.payload.AuthResponse;
import com.mizan.jwtauth.payload.LoginRequest;
import com.mizan.jwtauth.payload.SignUpRequest;
import com.mizan.jwtauth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService; // service for auth logic

    // signup endpoint
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        // call service to register
        String message = authService.register(signUpRequest);
        return ResponseEntity.ok().body(message); // return simple message
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(@RequestBody LoginRequest loginRequest){
//        call service to login and get token + user info
        AuthResponse response = authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}
