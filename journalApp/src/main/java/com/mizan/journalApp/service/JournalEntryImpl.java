package com.mizan.journalApp.service;

import com.mizan.journalApp.entity.JournalEntry;
import com.mizan.journalApp.entity.UserEntry;
import com.mizan.journalApp.repository.JournalEntryRepository;
import com.mizan.journalApp.repository.UserEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JournalEntryImpl implements JournalEntryService{

    private final JournalEntryRepository journalEntryRepository;
    private final UserEntryRepository userEntryRepository;

    @Override
    public JournalEntry create(Long id, JournalEntry journalEntry) {
        UserEntry userEntry = userEntryRepository.findById(id).orElseThrow();  // phle mujhe user find kar na hoga
        journalEntry.setUserEntry(userEntry);       // phir journalentries ko user ke sath linked karna hoga
        return journalEntryRepository.save(journalEntry);  // phir entry ko save kar dengge
     }

     @Override
     public List<JournalEntry> getAll(Long id) {
      UserEntry userEntry = userEntryRepository.findById(id).orElseThrow();
       return userEntry.getJournalEntries(); // user ka sara journalEntry nikal liya
     }

    @Override
    public JournalEntry getById(Long id, Long entryId) {
        return journalEntryRepository.findById(entryId).orElseThrow();
     }

     @Override
     public JournalEntry update(Long id, Long entryId, JournalEntry updated) {
        JournalEntry entry = getById(id,entryId);
        entry.setTitle(updated.getTitle());
        entry.setContent(updated.getContent());
        return journalEntryRepository.save(entry);
     }

     @Override
     public void deleteById(Long id, Long entryId) {
        journalEntryRepository.deleteById(entryId);
     }
}