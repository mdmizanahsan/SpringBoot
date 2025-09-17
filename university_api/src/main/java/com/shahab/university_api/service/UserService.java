package com.shahab.university_api.service;

import com.shahab.university_api.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User saveUser(User user);
    User findById(String id);
    User findByUsername(String username);
    void deleteUser(String id);
}