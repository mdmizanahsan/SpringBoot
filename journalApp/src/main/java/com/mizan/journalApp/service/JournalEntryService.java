package com.mizan.journalApp.service;

import com.mizan.journalApp.entity.JournalEntry;
import com.mizan.journalApp.repository.JournalEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    private final JournalEntryRepository journalEntryRepository;

    public JournalEntryService(JournalEntryRepository journalEntryRepository) {
        this.journalEntryRepository = journalEntryRepository;
    }

      public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
      }

      public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
      }

      public Optional<JournalEntry> findById(Long id) {
        return journalEntryRepository.findById(id);
      }

      public void deleteById(Long id) {
        journalEntryRepository.deleteById(id);
      }
}
