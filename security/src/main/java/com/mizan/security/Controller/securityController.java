package com.mizan.security.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class securityController {

    @GetMapping("/")
    public ResponseEntity<?> getDetails(HttpServletRequest request) {
        String id = request.getSession().getId();
        return new ResponseEntity<>("Hello , Welcome to code" +id,HttpStatus.OK);
    }
}
