package com.mizan.user.service;

import com.mizan.user.entity.UserEntity;
import com.mizan.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //GET ALL USER
    public List<UserEntity> getalluser() {
       return userRepository.findAll();
    }

    //GET SINGLE ID
    public UserEntity getUserById(Long id) {
       return userRepository.findById(id).orElse(null);
    }

    // SAVE
    public  UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }
}
