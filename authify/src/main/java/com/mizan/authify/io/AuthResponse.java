package com.mizan.authify.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
@Data
public class AuthResponse {

    private String email;
    private String token;
}
