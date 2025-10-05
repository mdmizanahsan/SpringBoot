package com.mizan.journalApp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JournalResponseDTO {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime date;
}
