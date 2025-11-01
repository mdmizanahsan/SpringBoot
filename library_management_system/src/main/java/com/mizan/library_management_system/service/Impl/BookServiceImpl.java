package com.mizan.library_management_system.service.Impl;

import com.mizan.library_management_system.dto.BookDTO;
import com.mizan.library_management_system.entity.Book;
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
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    @Override
    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with this " +id));
        return book;
    }
    @Override
    public Book addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTittle(bookDTO.getTittle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setIsAvailable(bookDTO.getIsAvailable());
        book.setQuantity(bookDTO.getQuantity());

        return bookRepository.save(book);
    }
    @Override
    public Book updateBook(Long id, BookDTO bookDTO) {
        Book oldBook = bookRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Book Not Found"));

        oldBook.setTittle(bookDTO.getTittle());
        oldBook.setAuthor(bookDTO.getAuthor());
        oldBook.setIsbn(bookDTO.getIsbn());
        oldBook.setIsAvailable(bookDTO.getIsAvailable());
        oldBook.setQuantity(bookDTO.getQuantity());

        return bookRepository.save(oldBook);
    }
    @Override
    public Void deleteBookById(Long id) {
        bookRepository.deleteById(id);
        return null;
    }
}
