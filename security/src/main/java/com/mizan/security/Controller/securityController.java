package com.mizan.security.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class securityController {

    @GetMapping("/")
    public ResponseEntity<?> getDetails() {
        return new ResponseEntity<>("Hello , Welcome to code" , HttpStatus.OK);
    }
}
