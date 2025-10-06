package com.mizan.journalApp.repository;

import com.mizan.journalApp.entity.UserEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;
import java.util.Optional;

public interface UserEntryRepository extends JpaRepository<UserEntry,Long> {


    Optional<Object> findByUsername(String username);
}
