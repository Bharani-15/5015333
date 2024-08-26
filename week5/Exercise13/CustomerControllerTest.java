package com.example.BookStoreAPI.test;

import com.example.BookStoreAPI.controller.CustomerController;
import com.example.BookStoreAPI.entity.Customer;
import com.example.BookStoreAPI.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testCreateCustomer() throws Exception {
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com");

        Mockito.when(customerService.createCustomer(ArgumentMatchers.any(Customer.class))).thenReturn(customer);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe\",\"email\":\"john.doe@example.com\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(customerService, Mockito.times(1)).createCustomer(ArgumentMatchers.any(Customer.class));
    }
}

