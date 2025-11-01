package com.mizan.library_management_system.dto;

import lombok.Data;

@Data
public class BookDTO {

    private String tittle;
    private String author;
    private String isbn;
    private Integer quantity;
    private Boolean isAvailable;
}
