package com.mizan.journalApp.controller;

import com.mizan.journalApp.entity.UserEntry;
import com.mizan.journalApp.service.UserEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserEntryController {

    private final UserEntryService userEntryService;

    @PostMapping
    public ResponseEntity<UserEntry> create(@RequestBody UserEntry userEntry) {
        try {
            userEntryService.createUser(userEntry);
            return new ResponseEntity<>(userEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
       List<UserEntry> userEntries =  userEntryService.getAll();
       if (userEntries != null && !userEntries.isEmpty()) {
           return new ResponseEntity<>(userEntries , HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserEntry>> getById(@PathVariable Long id) {
        Optional<UserEntry> userEntry1 = userEntryService.getById(id);
        if (userEntry1.isPresent()) {
            return new ResponseEntity<>(userEntry1,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntry> update(@RequestBody UserEntry userEntry ,@PathVariable Long id) {
        try {
            UserEntry userEntry1 = userEntryService.update(userEntry ,id);
            if (userEntry1 != null) {
                return new ResponseEntity<>(userEntry1,HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
           userEntryService.deleteById(id);
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
