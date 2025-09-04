package com.mizan.journelApp.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class JournelEntity {

    @Id
    private Long id;

    private String tittle;

    private String content;

    private LocalDateTime date;

    public void setDate(LocalDateTime now) {
    }
}
