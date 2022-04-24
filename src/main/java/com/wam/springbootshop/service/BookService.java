package com.wam.springbootshop.service;

import java.time.LocalDateTime;
import java.util.List;

import com.wam.springbootshop.model.Book;
import com.wam.springbootshop.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wyllian
 */

 @Service
public class BookService implements BookServiceable {
    
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        book.setCreateTime(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
    
}
