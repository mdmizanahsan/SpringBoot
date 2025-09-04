package com.mizan.user.controller;

import com.mizan.user.entity.UserEntity;
import com.mizan.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getalluser() {
      return userService.getalluser();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
      return userService.getUserById(id);
    }

    @PostMapping
    private UserEntity saveUser(@RequestBody UserEntity userEntity) {
       return userService.saveUser(userEntity);
    }
}
