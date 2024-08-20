package com.example.BookstoreAPI;

import com.example.BookstoreAPI.config.BookMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMetrics bookMetrics;

    @Autowired
    public BookService(BookRepository bookRepository, BookMetrics bookMetrics) {
        this.bookRepository = bookRepository;
        this.bookMetrics = bookMetrics;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        Book newBook = bookRepository.save(book);
        // Record the creation of a new book
        bookMetrics.incrementBookCreated();
        return newBook;
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    public Book saveBook(Book book) {
        // Here you can perform any additional logic before saving the book
        return bookRepository.save(book);
    }

    public List<Book> searchBooks(String title, String author) {
        if (title != null && author != null) {
            return bookRepository.findByTitleContainingAndAuthorContaining(title, author);
        } else if (title != null) {
            return bookRepository.findByTitleContaining(title);
        } else if (author != null) {
            return bookRepository.findByAuthorContaining(author);
        } else {
            return bookRepository.findAll();
        }
    }

    public boolean existsById(Long id) {
        return bookRepository.existsById(id);
    }
}
