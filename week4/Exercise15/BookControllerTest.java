package com.example.BookstoreAPI;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void testGetAllBooks() throws Exception {
        mockMvc.perform(get("/books")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateBook() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Sample Book");
        bookDTO.setAuthor("Sample Author");
        bookDTO.setPrice(new BigDecimal("19.99"));
        bookDTO.setIsbn("1234567890");

        when(bookService.saveBook(any(BookDTO.class))).thenReturn(bookDTO);

        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Sample Book"));
    }

    @Test
    public void testGetBookById() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Sample Book");
        bookDTO.setAuthor("Sample Author");
        bookDTO.setPrice(new BigDecimal("19.99"));
        bookDTO.setIsbn("1234567890");

        when(bookService.getBookById(1L)).thenReturn(bookDTO);

        mockMvc.perform(get("/books/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Sample Book"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/books/1"))
                .andExpect(status().isNoContent());
    }
}
