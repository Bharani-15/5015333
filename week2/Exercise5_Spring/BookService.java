package org.example;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void bookService() {
        System.out.println("BookService");
        bookRepository.Bookrepository1();
    }
}
