package com.example.BookstoreAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/books")
@Validated
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();

        // Adding HATEOAS link to each book in the list
        books.forEach(book -> {
            Link selfLink = WebMvcLinkBuilder.linkTo(BookController.class).slash(book.getId()).withSelfRel();
            book.add(selfLink); // Add link to book entity (assuming Book class is HATEOAS compatible)
        });

        // Add link to self
        Link selfLink = WebMvcLinkBuilder.linkTo(BookController.class).withSelfRel();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LINK, selfLink.getHref());

        return ResponseEntity.ok().headers(headers).body(books);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        Book newBook = bookService.saveBook(book);

        // Adding HATEOAS link
        Link selfLink = WebMvcLinkBuilder.linkTo(BookController.class).slash(newBook.getId()).withSelfRel();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LINK, selfLink.getHref());
        headers.add("X-Book-Created", "true");

        return new ResponseEntity<>(newBook, headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable @NotNull Long id) {
        if (!bookService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }

        bookService.deleteBook(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {

        List<Book> books = bookService.searchBooks(title, author);

        // Adding HATEOAS links to each book in the list
        books.forEach(book -> {
            Link selfLink = WebMvcLinkBuilder.linkTo(BookController.class).slash(book.getId()).withSelfRel();
            book.add(selfLink); // Add link to book entity (assuming Book class is HATEOAS compatible)
        });

        // Add link to self
        Link selfLink = WebMvcLinkBuilder.linkTo(BookController.class).withSelfRel();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LINK, selfLink.getHref());

        return ResponseEntity.ok().headers(headers).body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable @NotNull Long id) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }

        // Adding HATEOAS link
        Link selfLink = WebMvcLinkBuilder.linkTo(BookController.class).slash(id).withSelfRel();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LINK, selfLink.getHref());

        return new ResponseEntity<>(book, headers, HttpStatus.OK);
    }
}
