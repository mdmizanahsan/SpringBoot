package com.mizan.user_dashboard_api.service.impl;

import com.mizan.user_dashboard_api.entity.User;
import com.mizan.user_dashboard_api.repository.UserRepository;
import com.mizan.user_dashboard_api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    public User update(String id , User user) {
        User user1 = findById(id);
        if (user.getName()!=null) {
            user1.setName(user.getName());
        }
        if (user.getEmail()!=null) {
            user1.setEmail(user.getEmail());
        }
        return userRepository.save(user1);
    }
}
