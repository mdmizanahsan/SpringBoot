package com.mizan.library_management_system.service.Impl;

import com.mizan.library_management_system.exception.ResourceNotFoundException;
import com.mizan.library_management_system.model.Book;
import com.mizan.library_management_system.model.IssueRecord;
import com.mizan.library_management_system.model.Student;
import com.mizan.library_management_system.repository.BookRepository;
import com.mizan.library_management_system.repository.IssueRecordRepository;
import com.mizan.library_management_system.repository.StudentRepository;
import com.mizan.library_management_system.service.IssueRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueRecordServiceImpl implements IssueRecordService {

    private final IssueRecordRepository issueRecordRepository;
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;

    @Override
    public IssueRecord issueBook(Long bookId, Long studentId) {
       Book book = bookRepository.findById(bookId).orElseThrow(
               () -> new ResourceNotFoundException("Book not found with id " + bookId)
       );

         if (!book.isAvailable()) {
             throw new RuntimeException("Book is already issued !");
         }

       Student student = studentRepository.findById(studentId).orElseThrow(
               () -> new ResourceNotFoundException("Student not found with id " + studentId));

       IssueRecord record = IssueRecord.builder()
               .book(book)
               .student(student)
               .issueDate(LocalDate.now())
               .build();

       book.setAvailable(false);
       bookRepository.save(book);
       return issueRecordRepository.save(record);
    }

    @Override
    public IssueRecord returnBook(Long issueId) {
        IssueRecord record = issueRecordRepository.findById(issueId)
                .orElseThrow(() -> new ResourceNotFoundException("Issue record not found with id " + issueId));
           Book book = record.getBook();
           book.setAvailable(true);
           record.setReturnDate(LocalDate.now());

           bookRepository.save(book);
           return issueRecordRepository.save(record);
    }

    @Override
    public List<IssueRecord> getAllRecords() {
        return issueRecordRepository.findAll();
    }

}
