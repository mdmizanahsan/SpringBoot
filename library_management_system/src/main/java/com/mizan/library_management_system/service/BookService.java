package com.mizan.library_management_system.service;

import com.mizan.library_management_system.dto.BookDTO;
import com.mizan.library_management_system.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book addBook(BookDTO bookDTO);

    Book updateBook(Long id, BookDTO bookDTO);

    Void deleteBookById(Long id);
}
