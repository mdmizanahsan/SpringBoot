package com.mizan.jwtauth.service;

import com.mizan.jwtauth.config.JwtUtils;
import com.mizan.jwtauth.domain.Role;
import com.mizan.jwtauth.model.User;
import com.mizan.jwtauth.payload.AuthResponse;
import com.mizan.jwtauth.payload.LoginRequest;
import com.mizan.jwtauth.payload.SignUpRequest;
import com.mizan.jwtauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils; // generate/validate JWT

    @Autowired
    private CustomUserService customUserService; // load user details

    // register new aliya user
    public String register(SignUpRequest request) {
        // check if email already taken
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        // build user model and save
        User user = User.builder()
                .fullName(request.getFullName())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.valueOf(request.getRole().toUpperCase()))
                .build();

        userRepository.save(user);

        return "User registered successfully!";
    }

    // login and issues jwt
    public AuthResponse login(LoginRequest request) {
        // perform -> authentication : will throw if credentials invalid
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // set authentication in context (optional for rest calls)
        // get principal (user details)
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // generate JWT token using userDetails;

        String token = jwtUtils.generateToken(userDetails);

        // get user model to return additional info
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        // build response

        return new AuthResponse(token, "Bearer", user.getEmail(), user.getRole().name());

    }

}
