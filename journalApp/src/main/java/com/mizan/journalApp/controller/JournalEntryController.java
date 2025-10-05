package com.mizan.journalApp.controller;

import com.mizan.journalApp.dto.JournalRequestDTO;
import com.mizan.journalApp.dto.JournalResponseDTO;
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
@RequestMapping("/users/{userId}/journals")
public class JournalEntryController {

    private final JournalEntryService journalEntryService;

    @PostMapping
    public ResponseEntity<JournalResponseDTO> create(@PathVariable Long userId,
                                                     @RequestBody JournalRequestDTO dto) {
          return new ResponseEntity<>(journalEntryService.createEntry(userId,dto),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JournalResponseDTO>> getAll(@PathVariable Long userId) {
        return ResponseEntity.ok(journalEntryService.getAll(userId));
    }

    @GetMapping("/{entryId}")
    public ResponseEntity<JournalResponseDTO> getById(@PathVariable Long userId,
                                                @PathVariable Long entryId) {
        return ResponseEntity.ok(journalEntryService.getById(userId, entryId));
    }

    @PutMapping("/{entryId}")
    public ResponseEntity<JournalResponseDTO> update(@PathVariable Long userId, @PathVariable Long entryId,
                                               @RequestBody JournalRequestDTO dto) {
        return ResponseEntity.ok(journalEntryService.updateEntry(userId, entryId, dto));
    }

    @DeleteMapping("/{entryId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId,
                                       @PathVariable Long entryId) {
        journalEntryService.daleteEntry(userId, entryId);
        return ResponseEntity.noContent().build();
    }
}
