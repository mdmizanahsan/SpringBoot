package com.mizan.library_management_system.repository;

import com.mizan.library_management_system.model.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,Long> {

    UserDetails findByUsername(String username);

    boolean existsByUsername(@NotBlank(message = "username required") String username);
}
