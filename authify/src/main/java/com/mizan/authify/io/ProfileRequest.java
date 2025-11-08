package com.mizan.authify.io;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileRequest {

    @NotBlank(message = "Name should be not empty")
    private String name;
    @Email(message = "Enter valid email address")
    @NotNull(message = "Email should not be empty")
    private String email;
    private String password;

}
