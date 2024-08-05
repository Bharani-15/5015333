package com.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {
    @Autowired
    private BookRepository books;
    public void setBooks(BookRepository books) {
        this.books = books;
    }

    public BookRepository getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "BookService{" +
                "books=" + books +
                '}';
    }

    public String demo1(){
        return "Bookservice"+books;
    }
}
