package com.mizan.journalApp.repository;

import com.mizan.journalApp.entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryRepository extends JpaRepository<JournalEntry,Long> {
}
