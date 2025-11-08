package com.mizan.authify.service;

import com.mizan.authify.entity.UserEntity;
import com.mizan.authify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AppUserdetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        UserEntity existingUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("❌ Email not found for " + email));


        return new User(existingUser.getEmail(), existingUser.getPassword(), new ArrayList<>());
    }

}
