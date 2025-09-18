package com.mizan.signup.Service;

import com.mizan.signup.Dto.SignupRequest;
import com.mizan.signup.Dto.SignupResponse;
import com.mizan.signup.Entity.Role;
import com.mizan.signup.Entity.User;
import com.mizan.signup.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public SignupResponse registerUser(SignupRequest request) {
        // Check if user/email already exists
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("User already taken");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        // Encoded Password
        String encodedPassword = passwordEncoder.encode(request.getPassword());


        // String role → Enum role
        Role role = Role.valueOf(request.getRole().toUpperCase());

        // create user
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(encodedPassword)
                .role(role)
                .build();

       User savedUser =  userRepository.save(user);

        return SignupResponse.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .build();
    }
}
