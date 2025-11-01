package com.mizan.library_management_system.controller;

import com.mizan.library_management_system.entity.IssueRecord;
import com.mizan.library_management_system.service.BookService;
import com.mizan.library_management_system.service.IssueRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issuerecord")
@RequiredArgsConstructor
public class IssueRecordController {

      private final IssueRecordService issueRecordService;

      @PostMapping("/issuethebook/{bookid}")
      public ResponseEntity<IssueRecord> issueTheBook(@PathVariable Long bookId) {
          return ResponseEntity.ok(issueRecordService.issueTheBook(bookId));
      }

      @PostMapping("/returnthebook/{issuerecordid}")
      public ResponseEntity<IssueRecord> returnTheBook(@PathVariable Long issueRecordId) {
          return ResponseEntity.ok(issueRecordService.returnTheBook(issueRecordId));
      }
}
