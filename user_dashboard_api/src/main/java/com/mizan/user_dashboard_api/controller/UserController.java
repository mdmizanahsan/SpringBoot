package com.mizan.user_dashboard_api.controller;

import com.mizan.user_dashboard_api.entity.User;
import com.mizan.user_dashboard_api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        try {
            user.setJoinedAt(LocalDateTime.now());

            if(user.getNotifications() != null) {
                user.getNotifications().forEach(notification -> {
                    notification.setTimeStamp(LocalDateTime.now());
                    notification.setUser(user);
                    if(notification.getRead() == null) {
                        notification.setRead(false);
                    }
                });
            }

            User created = userService.create(user);
            return new ResponseEntity<>(created, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping
    public ResponseEntity<?> getAll() {
        List<User> old =  userService.getAll();
        if (old != null && !old.isEmpty()) {
            return new ResponseEntity<>(old ,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        Optional<User> user = Optional.ofNullable(userService.findById(id));
        if (user.isPresent()) {
            return new ResponseEntity(user.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody User user){
        return ResponseEntity.ok(userService.update(id,user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        userService.deleteById(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
