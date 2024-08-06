package org.example;

import org.springframework.stereotype.Component;

public class BookService {
    private BookRepository bookRepository;
    String name;


    public BookService(String name) {
        this.name = name;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void demo(){
        System.out.println("BookService "+name+" "+bookRepository.Bookrepository1());
    }

}

