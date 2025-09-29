package com.mizan.journalApp.service;

import com.mizan.journalApp.entity.UserEntry;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;

public interface UserEntryService {


    UserEntry createUser(UserEntry userEntry);

    List<UserEntry> getAll();

    Optional<UserEntry> getById(Long id);

    UserEntry update(UserEntry userEntry, Long id);

    void deleteById(Long id);
}
