package com.wam.springbootshop.service;

import java.util.List;

import com.wam.springbootshop.model.Book;

/**
 * @author Wyllian
 */

public interface BookServiceable {
    Book saveBook(Book book);
    void deleteBook(Long id);
    List<Book> findAllBooks();
}
