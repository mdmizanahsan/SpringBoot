package com.shahab.university_api.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private String userId;
    private String username;
    private String email;
    private Set<String> roles;
}