package com.mizan.signup.Repository;

import com.mizan.signup.Dto.SignupRequest;
import com.mizan.signup.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
