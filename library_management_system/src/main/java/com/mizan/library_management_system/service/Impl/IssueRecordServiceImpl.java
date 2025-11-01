package com.mizan.library_management_system.service.Impl;

import com.mizan.library_management_system.entity.Book;
import com.mizan.library_management_system.entity.IssueRecord;
import com.mizan.library_management_system.entity.User;
import com.mizan.library_management_system.repository.BookRepository;
import com.mizan.library_management_system.repository.IssueRecordRepository;
import com.mizan.library_management_system.repository.UserRepository;
import com.mizan.library_management_system.service.IssueRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class IssueRecordServiceImpl implements IssueRecordService {

    private final IssueRecordRepository issueRecordRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public IssueRecord issueTheBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()-> new RuntimeException("Book Not Found"));

        if(book.getQuantity()<=0 || !book.getIsAvailable()) {
            throw new RuntimeException("Book is not available");
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = (User) userRepository.findByUsername(username)
                .orElseThrow( ()-> new RuntimeException("User not Found"));

        IssueRecord issueRecord = new IssueRecord();
        issueRecord.setIssueData(LocalDate.now());
        issueRecord.setDueData(LocalDate.now().plusDays(14));
        issueRecord.setIsReturned(false);
        issueRecord.setUser(user);
        issueRecord.setBook(book);

        book.setQuantity(book.getQuantity() - 1);
        if (book.getQuantity()==0) {
            book.setIsAvailable(false);
        }
        bookRepository.save(book);
        return issueRecordRepository.save(issueRecord);
    }

    @Override
    public IssueRecord returnTheBook(Long issueRecordId) {
        IssueRecord issueRecord = issueRecordRepository.findById(issueRecordId)
                .orElseThrow( ()-> new RuntimeException("Issue Record not found"));

        if (issueRecord.getIsReturned()) {
            throw new RuntimeException("Book Already returned");
        }

        Book book = issueRecord.getBook();
        book.setQuantity(book.getQuantity()+1);
        book.setIsAvailable(true);
        bookRepository.save(book);

        issueRecord.setReturnData(LocalDate.now());
        issueRecord.setIsReturned(true);
       return issueRecordRepository.save(issueRecord);
    }
}
