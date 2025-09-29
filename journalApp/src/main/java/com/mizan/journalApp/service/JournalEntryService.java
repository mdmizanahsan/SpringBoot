package com.mizan.journalApp.service;

import com.mizan.journalApp.entity.JournalEntry;

import java.util.List;

public interface JournalEntryService {

    JournalEntry create(Long id, JournalEntry journalEntry);

    List<JournalEntry> getAll(Long id);

    JournalEntry getById(Long id, Long entryId);

    JournalEntry update(Long id, Long entryId, JournalEntry updated);

    void deleteById(Long id, Long entryId);
}
