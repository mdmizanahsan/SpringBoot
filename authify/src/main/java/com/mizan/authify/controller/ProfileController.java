package com.mizan.authify.controller;

import com.mizan.authify.io.ProfileRequest;
import com.mizan.authify.io.ProfileResponse;
import com.mizan.authify.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1.0")
public class ProfileController {

    private final ProfileService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse register(@Valid @RequestBody ProfileRequest request) {
       ProfileResponse response =  userService.createProfile(request);
       return response;
    }

    @GetMapping("/test")
    public String test() {
        return "Auth is Working";
    }
}
