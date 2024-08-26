package com.example.BookStoreAPI.test;

import com.example.BookStoreAPI.controller.BookController;
import com.example.BookStoreAPI.entity.Book;
import com.example.BookStoreAPI.service.BookService;
import org.mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void testGetAllBooks() throws Exception {
        Book book1 = new Book(1L, "Book One", "Author One", 10.0, "ISBN001");
        Book book2 = new Book(2L, "Book Two", "Author Two", 15.0, "ISBN002");
        List<Book> books = Arrays.asList(book1, book2);

        Mockito.when(bookService.getAllBooks()).thenReturn(books);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Book One"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].title").value("Book Two"));

        Mockito.verify(bookService, Mockito.times(1)).getAllBooks();
    }

    @Test
    public void testGetBookById() throws Exception {
        Book book = new Book(1L, "Book One", "Author One", 10.0, "ISBN001");

        Mockito.when(bookService.getBookById(1L)).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Book One"));

        Mockito.verify(bookService, Mockito.times(1)).getBookById(1L);
    }

    @Test
    public void testCreateBook() throws Exception {
        Book book = new Book(1L, "Book One", "Author One", 10.0, "ISBN001");

        Mockito.when(bookService.createBook(ArgumentMatchers.any(Book.class))).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Book One\",\"author\":\"Author One\",\"price\":10.0,\"isbn\":\"ISBN001\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Book One"));

        Mockito.verify(bookService, Mockito.times(1)).createBook(ArgumentMatchers.any(Book.class));
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book book = new Book(1L, "Updated Book", "Updated Author", 12.0, "ISBN001");

        Mockito.when(bookService.updateBook(ArgumentMatchers.eq(1L), ArgumentMatchers.any(Book.class))).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Updated Book\",\"author\":\"Updated Author\",\"price\":12.0,\"isbn\":\"ISBN001\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Updated Book"));

        Mockito.verify(bookService, Mockito.times(1)).updateBook(ArgumentMatchers.eq(1L), ArgumentMatchers.any(Book.class));
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/books/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        Mockito.verify(bookService, Mockito.times(1)).deleteBook(1L);
    }
}
