package com.mizan.user.controller;

import com.mizan.user.entity.UserEntity;
import com.mizan.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            Long deletedId = userService.deleteUserById(id);
            return ResponseEntity.ok("User with ID " + deletedId + " deleted successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(
            @PathVariable Long id,
            @RequestBody UserEntity userDetails) {
        try {
            UserEntity updatedUser = userService.updateUser(id, userDetails);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }



}
