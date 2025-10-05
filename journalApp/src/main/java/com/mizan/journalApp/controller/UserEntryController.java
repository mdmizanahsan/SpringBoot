package com.mizan.journalApp.controller;

import com.mizan.journalApp.dto.JournalRequestDTO;
import com.mizan.journalApp.dto.UserRequestDTO;
import com.mizan.journalApp.dto.UserResponseDTO;
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
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO dto) {
        return new ResponseEntity<>(userEntryService.createUser(dto),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
         return ResponseEntity.ok(userEntryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id) {
         return ResponseEntity.ok(userEntryService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id , @RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok(userEntryService.updateUser(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userEntryService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
