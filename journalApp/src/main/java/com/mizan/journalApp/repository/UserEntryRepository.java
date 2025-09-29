package com.mizan.journalApp.repository;

import com.mizan.journalApp.entity.UserEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntryRepository extends JpaRepository<UserEntry,Long> {

}
