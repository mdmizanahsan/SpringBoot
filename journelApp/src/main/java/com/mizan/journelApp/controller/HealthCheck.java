package com.mizan.journelApp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/health-care")
    public String healthCheck()
    {
        return "OK";
    }
}
