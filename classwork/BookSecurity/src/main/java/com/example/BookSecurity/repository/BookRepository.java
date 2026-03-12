package com.example.BookSecurity.repository;

import com.example.BookSecurity.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
}
