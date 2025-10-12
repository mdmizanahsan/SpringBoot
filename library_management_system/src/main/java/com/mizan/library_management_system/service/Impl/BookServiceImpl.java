package com.mizan.library_management_system.service.Impl;

import com.mizan.library_management_system.exception.ResourceNotFoundException;
import com.mizan.library_management_system.model.Book;
import com.mizan.library_management_system.repository.BookRepository;
import com.mizan.library_management_system.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Long id, Book bookdetails) {
      Book book = bookRepository.findById(id)
              .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));

      book.setTitle(bookdetails.getTitle());
      book.setAuthor(bookdetails.getAuthor());
      book.setIsbn(bookdetails.getIsbn());
      book.setAvailable(bookdetails.isAvailable());

      return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
