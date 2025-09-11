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
    public UserResponse getUserById(@PathVariable Long Id) {
        User user = userService.getUserById(Id);

        if (user != null) {
            return UserResponse.builder()
                    .timestamp(LocalDateTime.now().toString())
                    .transactionId(UUID.randomUUID().toString())
                    .status("OK")
                    .code("200.200")
                    .message(Arrays.asList("User fetched successfully with id: " + Id))
                    .users(Arrays.asList(user))
                    .build();
        } else {
            return UserResponse.builder()
                    .timestamp(LocalDateTime.now().toString())
                    .transactionId(UUID.randomUUID().toString())
                    .status("ERROR")
                    .code("404.404")
                    .message(Arrays.asList("User not found with id: " + Id))
                    .users(Arrays.asList())
                    .build();
        }
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

    // Update User by ID
    @PutMapping("/{Id}")
    public UserResponse updateUser(@PathVariable Long Id, @RequestBody User user) {
        User updatedUser = userService.updateUser(Id, user);

        if (updatedUser != null) {
            return UserResponse.builder()
                    .timestamp(LocalDateTime.now().toString())
                    .transactionId(UUID.randomUUID().toString())
                    .status("OK")
                    .code("200.200")
                    .message(Arrays.asList("User updated successfully"))
                    .users(Arrays.asList(updatedUser))
                    .build();
        } else {
            return UserResponse.builder()
                    .timestamp(LocalDateTime.now().toString())
                    .transactionId(UUID.randomUUID().toString())
                    .status("ERROR")
                    .code("404.404")
                    .message(Arrays.asList("User not found with id: " + Id))
                    .users(Arrays.asList())
                    .build();
        }
    }


    @DeleteMapping("/{Id}")
    public UserResponse deleteUser(@PathVariable Long Id) {
        try {
            Long deletedId = userService.deleteUserById(Id);

            return UserResponse.builder()
                    .timestamp(LocalDateTime.now().toString())
                    .transactionId(UUID.randomUUID().toString())
                    .status("OK")
                    .code("200.200")
                    .message(Arrays.asList("User deleted successfully with id: " + deletedId))
                    .users(Arrays.asList())
                    .build();
        } catch (RuntimeException e) {
            return UserResponse.builder()
                    .timestamp(LocalDateTime.now().toString())
                    .transactionId(UUID.randomUUID().toString())
                    .status("ERROR")
                    .code("404.404")
                    .message(Arrays.asList(e.getMessage()))
                    .users(Arrays.asList())
                    .build();
        }
    }

}
