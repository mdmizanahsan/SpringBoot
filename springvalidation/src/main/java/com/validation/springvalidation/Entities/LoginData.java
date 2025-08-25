package com.validation.springvalidation.Entities;


import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginData {

    @NotBlank(message = "User name can not be empty !!")
    @Size(min = 3, max = 12, message = "User name must be in 3-12 characters")
    private String userName;

    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" , message = "Invalid Email!!")
    private String email;

    @AssertTrue(message = "Must agree term and condition")
    private boolean agreed;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public @AssertTrue boolean isAgreed() {
        return agreed;
    }

    public void setAgreed(@AssertTrue boolean agreed) {
        this.agreed = agreed;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
