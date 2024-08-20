package com.example.BookstoreAPI;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    BookService bookService;
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }


}
