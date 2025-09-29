package com.mizan.journalApp.controller;

import com.mizan.journalApp.entity.JournalEntry;
import com.mizan.journalApp.service.JournalEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/{id}/journals")
public class JournalEntryController {

    private final JournalEntryService journalEntryService;

    @PostMapping
    public ResponseEntity<JournalEntry> create(@PathVariable Long id , @RequestBody JournalEntry journalEntry) {
        try {
           JournalEntry saved = journalEntryService.create(id,journalEntry);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<JournalEntry>> getAll(@PathVariable Long id) {
       List<JournalEntry> entries =  journalEntryService.getAll(id);
       return new ResponseEntity<>(entries,HttpStatus.OK);
    }

    @GetMapping("/{entryId}")
    public ResponseEntity<JournalEntry> getById(@PathVariable Long id,
                                                @PathVariable Long entryId) {
        JournalEntry entry = journalEntryService.getById(id, entryId);
        return new ResponseEntity<>(entry, HttpStatus.OK); // 200
    }

    @PutMapping("/{entryId}")
    public ResponseEntity<JournalEntry> update(@PathVariable Long id, @PathVariable Long entryId,
                                               @RequestBody JournalEntry journalEntry) {
       JournalEntry updated = journalEntryService.update(id,entryId,journalEntry);
       return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("/{entryId}")
    public ResponseEntity<Void> delete(@PathVariable Long id,
                                       @PathVariable Long entryId) {
        journalEntryService.deleteById(id,entryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
    }
}
