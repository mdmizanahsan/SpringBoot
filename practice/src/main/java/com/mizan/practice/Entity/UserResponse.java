package com.mizan.practice.Entity;

import jakarta.persistence.ElementCollection;
import lombok.Data;

import java.util.List;


@Data

public class UserResponse {

    @ElementCollection
    private List<User> users;
}
