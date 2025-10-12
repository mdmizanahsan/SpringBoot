package com.mizan.library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class JwtResponse {

    private String token;
    private String tokenType = "Bearer";
    private String username;
    private String role;
}
