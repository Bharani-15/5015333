package com.example.BookStoreAPI.repository;

import com.example.BookStoreAPI.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}
