package com.mizan.security.repo;

import com.mizan.security.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
