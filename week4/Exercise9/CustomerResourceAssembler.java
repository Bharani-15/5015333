package com.example.BookstoreAPI.assembler;
import com.example.BookstoreAPI.customer.CustomerController;
import com.example.BookstoreAPI.dto.CustomerDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomerResourceAssembler {

    public EntityModel<CustomerDTO> toModel(CustomerDTO customerDTO) {
        EntityModel<CustomerDTO> customerResource = EntityModel.of(customerDTO);

        Link selfLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(CustomerController.class).createCustomer(customerDTO))
                .withSelfRel();

        Link allCustomersLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(CustomerController.class).registerCustomer(customerDTO))
                .withRel("all-customers");

        customerResource.add(selfLink, allCustomersLink);
        return customerResource;
    }
}
