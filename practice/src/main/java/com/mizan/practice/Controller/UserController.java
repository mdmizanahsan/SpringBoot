package com.mizan.practice.Controller;

import com.mizan.practice.Entity.User;
import com.mizan.practice.Service.UserService;
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
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{Id}")
    public User getUserById(@PathVariable Long Id) {
        return userService.getUserById(Id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{Id}")
    public Long deleteUser(@PathVariable Long Id ) {
        return userService.deleteUserById(Id);
    }
}
