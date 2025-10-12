package com.mizan.library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IssueRecordDTO {
    private Long id;

    private Long bookId;
    private Long studentId;

    private LocalDate issueDate;
    private LocalDate returnDate;
}
