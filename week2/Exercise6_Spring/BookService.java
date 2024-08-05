package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void bookService() {
        System.out.println("BookService");
        bookRepository.Bookrepository1();
    }
}
