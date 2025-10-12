package com.mizan.library_management_system.service;

import com.mizan.library_management_system.model.IssueRecord;

import java.util.List;

public interface IssueRecordService {
    IssueRecord issueBook(Long bookId, Long studentId);

    IssueRecord returnBook(Long issueId);

    List<IssueRecord> getAllRecords();
}
