package com.mizan.journalApp.repository;

import com.mizan.journalApp.entity.UserEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;

public interface UserEntryRepository extends JpaRepository<UserEntry,Long> {

    <T> ScopedValue<T> findByUsername(String username);
}
