package com.mizan.practice.Entity;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String timestamp;
    private String transactionId;
    private String status;
    private String code;
    private List<String> message;

    private List<User> users;


}
