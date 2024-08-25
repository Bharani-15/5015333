package com.example.BookStoreAPI.test;

import com.example.BookStoreAPI.entity.Book;
import com.example.BookStoreAPI.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setup() {
        // Clear the repository before each test
        bookRepository.deleteAll();
    }

    @Test
    public void testCreateAndRetrieveBook() throws Exception {
        String bookJson = "{\"title\":\"Book One\",\"author\":\"Author One\",\"price\":10.0,\"isbn\":\"ISBN001\"}";

        // Test creating a new book
        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Book One"));

        // Test retrieving the book
        Book savedBook = bookRepository.findAll().get(0);
        mockMvc.perform(get("/api/books/" + savedBook.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Book One"));
    }

    @Test
    public void testUpdateBook() throws Exception {
        // Create a book
        Book book = new Book(null, "Book One", "Author One", 10.0, "ISBN001");
        book = bookRepository.save(book);

        // Update the book
        String updatedBookJson = "{\"title\":\"Updated Book\",\"author\":\"Updated Author\",\"price\":12.0,\"isbn\":\"ISBN001\"}";
        mockMvc.perform(put("/api/books/" + book.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedBookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Book"));

        // Verify the update
        mockMvc.perform(get("/api/books/" + book.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Book"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        // Create a book
        Book book = new Book(null, "Book One", "Author One", 10.0, "ISBN001");
        book = bookRepository.save(book);

        // Delete the book
        mockMvc.perform(delete("/api/books/" + book.getId()))
                .andExpect(status().isNoContent());

        // Verify the book was deleted
        mockMvc.perform(get("/api/books/" + book.getId()))
                .andExpect(status().isNotFound());
    }
}

