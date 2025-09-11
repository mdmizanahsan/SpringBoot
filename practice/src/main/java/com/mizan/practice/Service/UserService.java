package com.mizan.practice.Service;

import com.mizan.practice.Entity.User;
import com.mizan.practice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public  List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET by Id
    public User getUserById(Long Id) {
        return userRepository.findById(Id).orElse(null);
    }

    //Save
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Delete by Id
    public Long deleteUserById(Long Id) {
        if (userRepository.existsById(Id)) {
            userRepository.deleteById(Id);
            return Id;
        } else {
            throw new RuntimeException("User not found with id: " + Id);
        }
    }
}
