package com.mizan.journalApp.service;

import com.mizan.journalApp.entity.UserEntry;
import com.mizan.journalApp.repository.UserEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserEntryImpl implements UserEntryService{

    private final UserEntryRepository userEntryRepository;


    @Override
    public UserEntry createUser(UserEntry userEntry) {
        return userEntryRepository.save(userEntry);
    }

    @Override
    public List<UserEntry> getAll() {
        return userEntryRepository.findAll();
    }

    @Override
    public Optional<UserEntry> getById(Long id) {
        return userEntryRepository.findById(id);
    }

    @Override
    public UserEntry update(UserEntry userEntry, Long id) {
        UserEntry userEntry1 = userEntryRepository.findById(id).orElse(null);
        userEntry1.setUsername(userEntry.getUsername());
        userEntry1.setPassword(userEntry.getPassword());
        return userEntryRepository.save(userEntry1);
    }

    @Override
    public void deleteById(Long id) {
        userEntryRepository.deleteById(id);
    }
}
