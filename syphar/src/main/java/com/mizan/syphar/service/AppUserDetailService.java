package com.mizan.syphar.service;

import com.mizan.syphar.entity.UserEntity;
import com.mizan.syphar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
          UserEntity existingUser =  userRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("Email not found for the email: "+email));
          return new User(existingUser.getEmail(), existingUser.getPassword(), new ArrayList<>());
    }


}
