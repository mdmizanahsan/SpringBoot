package com.mizan.jwtauth.payload;

import lombok.Data;

@Data
public class SignUpRequest {

    private String fullName;
    private String username;
    private String email;
    private String password;
    private String role;

}
