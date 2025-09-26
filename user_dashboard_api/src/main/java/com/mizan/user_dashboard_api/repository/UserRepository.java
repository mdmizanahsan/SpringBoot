package com.mizan.user_dashboard_api.repository;

import com.mizan.user_dashboard_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
