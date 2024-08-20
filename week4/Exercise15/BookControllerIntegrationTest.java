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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.sql.DataSource;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test") // Use application-test.properties or equivalent for test-specific settings
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateBook() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Integration Test Book");
        bookDTO.setAuthor("Integration Test Author");
        bookDTO.setPrice(new BigDecimal("29.99"));
        bookDTO.setIsbn("0987654321");

        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Integration Test Book"));
    }

    @Test
    public void testGetAllBooks() throws Exception {
        mockMvc.perform(get("/books")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetBookById() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Integration Test Book");
        bookDTO.setAuthor("Integration Test Author");
        bookDTO.setPrice(new BigDecimal("29.99"));
        bookDTO.setIsbn("0987654321");

        when(bookService.getBookById(1L)).thenReturn(bookDTO);

        mockMvc.perform(get("/books/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Integration Test Book"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/books/1"))
                .andExpect(status().isNoContent());
    }
}
