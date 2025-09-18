package com.mizan.signup.Dto;

import com.mizan.signup.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupResponse {

    private Long id;
    private String username;
    private String email;
    private Role role;
}
