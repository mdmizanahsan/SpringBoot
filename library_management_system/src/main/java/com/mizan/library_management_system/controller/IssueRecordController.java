package com.mizan.library_management_system.controller;

import com.mizan.library_management_system.model.IssueRecord;
import com.mizan.library_management_system.service.IssueRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/issue")
public class IssueRecordController {

    private final IssueRecordService issueRecordService;

    @PostMapping("/{bookId}/{studentId}")
    public IssueRecord issueBook(@PathVariable Long bookId, @PathVariable Long studentId) {
        return issueRecordService.issueBook(bookId, studentId);
    }

    @PutMapping("/return/{issueId}")
    public IssueRecord returnBook(@PathVariable Long issueId) {
        return issueRecordService.returnBook(issueId);
    }

    @GetMapping
    public List<IssueRecord> getAllRecords() {
        return issueRecordService.getAllRecords();
    }
}
