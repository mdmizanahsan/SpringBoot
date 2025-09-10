package com.mizan.practice.Repository;

import com.mizan.practice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User ,Long> {


}
