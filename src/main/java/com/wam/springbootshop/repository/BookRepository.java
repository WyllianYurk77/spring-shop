package com.wam.springbootshop.repository;

/**
 * @author Wyllian
 */

import com.wam.springbootshop.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
