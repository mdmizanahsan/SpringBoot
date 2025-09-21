package com.mizan.journalApp.controller;


import com.mizan.journalApp.entity.JournalEntry;
import com.mizan.journalApp.service.JournalEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntityController {


    private final JournalEntryService journalEntryService;

    public JournalEntityController(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;
    }

    @GetMapping
     public ResponseEntity<?> getAll() {
            List<JournalEntry> old =  journalEntryService.getAll();
            if (old != null && !old.isEmpty()) {
                return new ResponseEntity<>(old ,HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }

     @PostMapping
     public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) {
        try {
            myEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myEntry);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

     }

     @GetMapping ("/{id}")
     public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable Long id) {
       Optional<JournalEntry> journalEntry =  journalEntryService.findById(id);
        if (journalEntry.isPresent()) {
            return new ResponseEntity<>(journalEntry.get() , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<?> deleteJournalEntryById(@PathVariable Long id) {
        journalEntryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

     @PutMapping("/{id}")
     public ResponseEntity<JournalEntry> updateJournalEntryById(@PathVariable Long id ,@RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.findById(id).orElse(null);
        if (old != null) {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            journalEntryService.saveEntry(old);
            return new ResponseEntity<>(old , HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
}
