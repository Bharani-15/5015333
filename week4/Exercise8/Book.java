package com.example.BookstoreAPI;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String title;

    @NotNull
    private String author;

    @NotNull
    private BigDecimal price;

    @NotNull
    @Size(max = 13)
    private String isbn;

    @Version
    private Long version;

    // Getters and setters
}

