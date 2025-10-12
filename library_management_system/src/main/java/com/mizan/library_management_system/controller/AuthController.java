package com.mizan.library_management_system.controller;

import com.mizan.library_management_system.domain.Role;
import com.mizan.library_management_system.dto.JwtResponse;
import com.mizan.library_management_system.dto.LoginRequest;
import com.mizan.library_management_system.dto.RegisterRequest;
import com.mizan.library_management_system.repository.UserRepository;
import com.mizan.library_management_system.security.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import com.mizan.library_management_system.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;




    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest req) {

        if (userRepository.existsByUsername(req.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }

        Role role;
        try {
            role = (req.getRole() == null) ? Role.STUDENT : Role.valueOf(req.getRole().toUpperCase());
        } catch (Exception e) {
            role = Role.STUDENT;
        }

        User user = User.builder()
                .username(req.getUsername())
                .password(passwordEncoder.encode(req.getPassword()))
                .role(role)
                .build();

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
        );

        // if no exception, authentication successful
        User user = (User) auth.getPrincipal();
        String token = jwtService.generateToken(user);

        JwtResponse resp = JwtResponse.builder()
                .token(token)
                .username(user.getUsername())
                .role(user.getRole().name())
                .build();

        return ResponseEntity.ok(resp);
    }

}
