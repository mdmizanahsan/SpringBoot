package com.mizan.security.service;

import com.mizan.security.model.UserPrincipal;
import com.mizan.security.model.Users;
import com.mizan.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDeatailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);

          if (user == null) {
              System.out.println("USer Not Found");
              throw new UsernameNotFoundException("User Not Found");
          }
        return new UserPrincipal(user);
    }
}
