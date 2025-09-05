package com.mizan.journelApp.Entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "journal_entries")
@Data
public class JournelEntity {

    @Id
    private Object id;

    private String tittle;

    private String content;

    private LocalDateTime date;

    public void setDate(LocalDateTime now) {
    }
}
