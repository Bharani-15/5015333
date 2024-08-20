package com.example.BookstoreAPI.assembler;
import com.example.BookstoreAPI.BookController;
import com.example.BookstoreAPI.dto.BookDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilderDslKt.withRel;

@Component
public class BookResourceAssembler {

    public EntityModel<BookDTO> toModel(BookDTO bookDTO) {
        EntityModel<BookDTO> bookResource = EntityModel.of(bookDTO);

        Link selfLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(BookController.class).getBookById(bookDTO.getId()))
                .withSelfRel();

        Link allBooksLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks())
                .withRel("all-books");

        bookResource.add(selfLink, allBooksLink);
        return bookResource;
    }
}
