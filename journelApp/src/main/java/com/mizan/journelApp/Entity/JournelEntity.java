package com.mizan.journelApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class JournelEntity {

    @Id
    private Long id;

    private String tittle;

    private String content;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;

    }

    public void setContent(String content) {
        this.content = content;
    }
}
