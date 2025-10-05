package com.mizan.journalApp.service.Impl;

import com.mizan.journalApp.dto.JournalRequestDTO;
import com.mizan.journalApp.dto.JournalResponseDTO;
import com.mizan.journalApp.entity.JournalEntry;
import com.mizan.journalApp.entity.UserEntry;
import com.mizan.journalApp.repository.JournalEntryRepository;
import com.mizan.journalApp.repository.UserEntryRepository;
import com.mizan.journalApp.service.JournalEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JournalEntryImpl implements JournalEntryService {

    private final JournalEntryRepository journalEntryRepository;
    private final UserEntryRepository userEntryRepository;

     private JournalResponseDTO mapToResponse(JournalEntry entry) {
         JournalResponseDTO jdto = new JournalResponseDTO();
         jdto.setId(entry.getId());
         jdto.setTitle(entry.getTitle());
         jdto.setContent(entry.getContent());
         jdto.setDate(entry.getDate());
         return jdto;
     }

     @Override
     public JournalResponseDTO createEntry(Long userId, JournalRequestDTO dto) {
       UserEntry user = userEntryRepository.findById(userId).orElseThrow();
       JournalEntry entry = new JournalEntry();
       entry.setTitle(dto.getTitle());
       entry.setContent(dto.getContent());
       entry.setDate(LocalDateTime.now());
       entry.setUserEntry(user);
       return mapToResponse(journalEntryRepository.save(entry));
     }

     @Override
     public List<JournalResponseDTO> getAll(Long userId) {
        UserEntry user = userEntryRepository.findById(userId).orElseThrow();
        return user.getJournalEntries().stream().map(this::mapToResponse).collect(Collectors.toList());
     }

     @Override
     public JournalResponseDTO getById(Long userId, Long entryId) {
        JournalEntry entry = journalEntryRepository.findById(entryId).orElseThrow();
        return mapToResponse(entry);
     }

     @Override
     public JournalResponseDTO updateEntry(Long userId, Long entryId, JournalRequestDTO dto) {
        JournalEntry entry = journalEntryRepository.findById(entryId).orElseThrow();
        entry.setTitle(dto.getTitle());
        entry.setContent(dto.getContent());
        entry.setDate(LocalDateTime.now());
        return mapToResponse(journalEntryRepository.save(entry));
     }

     @Override
     public void daleteEntry(Long userId, Long entryId) {
         journalEntryRepository.deleteById(entryId);
     }
}