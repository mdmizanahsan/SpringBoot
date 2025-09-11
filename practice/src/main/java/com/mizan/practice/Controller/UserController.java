package com.mizan.practice.Controller;

import com.mizan.practice.Entity.User;
import com.mizan.practice.Entity.UserResponse;
import com.mizan.practice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.Arrays;

import java.time.LocalDateTime;
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
    public UserResponse getAllUsers() {
        List<User> users = userService.getAllUsers();
        return UserResponse.builder()
                .timestamp(LocalDateTime.now().toString())
                .transactionId(UUID.randomUUID().toString())
                .status("OK")
                .code("200.200")
                .message(Arrays.asList("User list fetched successfully, RecordCount: " + users.size()))
                .users(users)
                .build();
    }

    @GetMapping("/{Id}")
    public User getUserById(@PathVariable Long Id) {
        return userService.getUserById(Id);
    }
    @PostMapping
    public UserResponse saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);

        return UserResponse.builder()
                .timestamp(LocalDateTime.now().toString())
                .transactionId(UUID.randomUUID().toString())
                .status("OK")
                .code("201.201")
                .message(Arrays.asList("User created successfully"))
                .users(Arrays.asList(savedUser))
                .build();
    }

    @DeleteMapping("/{Id}")
    public Long deleteUser(@PathVariable Long Id ) {
        return userService.deleteUserById(Id);
    }
}
