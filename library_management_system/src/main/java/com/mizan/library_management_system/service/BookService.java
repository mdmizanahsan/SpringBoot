package com.mizan.library_management_system.service;

import com.mizan.library_management_system.model.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);

    List<Book> getAllBooks();

    Book updateBook(Long id, Book bookdetails);

    void deleteBook(Long id);
}
