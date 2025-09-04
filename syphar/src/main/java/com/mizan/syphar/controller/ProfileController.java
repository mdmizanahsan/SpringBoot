package com.mizan.syphar.controller;


import com.mizan.syphar.io.ProfileRequest;
import com.mizan.syphar.io.ProfileResponse;
import com.mizan.syphar.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProfileController {

    @Autowired
 private final ProfileService profileService;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse register(@Valid @RequestBody ProfileRequest request) {
       ProfileResponse response =  profileService.createProfile(request);
       return response;

    }
}
