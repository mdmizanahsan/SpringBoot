package com.mizan.jwtauth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class ProductController {

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            System.out.println("ATTEMPT api without authentication");
        }

        List<String> products = List.of("IPHONE 17", "SAMSUNG S25 ULTRA", "ONE PLUS", "NOKIA", "ALIYA_IK_BRANDED_PHONE");

        System.out.println("Products response for user: " + authentication.getName() + " -> " + products);

        return ResponseEntity.ok(products);
    }

}
