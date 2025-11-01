package com.mizan.library_management_system.service;

import com.mizan.library_management_system.entity.IssueRecord;

public interface IssueRecordService {
    IssueRecord issueTheBook(Long bookId);

    IssueRecord returnTheBook(Long issueRecordId);
}
