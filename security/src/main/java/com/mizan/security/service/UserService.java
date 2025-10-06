package com.mizan.security.service;

import com.mizan.security.model.Users;
import com.mizan.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Users register(Users user) {
        return userRepo.save(user);
    }
}
