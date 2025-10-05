package com.mizan.journalApp.service;

import com.mizan.journalApp.dto.JournalRequestDTO;
import com.mizan.journalApp.dto.JournalResponseDTO;
import com.mizan.journalApp.entity.JournalEntry;

import java.util.List;

public interface JournalEntryService {


    JournalResponseDTO createEntry(Long id, JournalRequestDTO dto);

    List<JournalResponseDTO> getAll(Long userId);

    JournalResponseDTO getById(Long userId, Long entryId);

    JournalResponseDTO updateEntry(Long userId, Long entryId, JournalRequestDTO dto);

    void daleteEntry(Long userId, Long entryId);
}
