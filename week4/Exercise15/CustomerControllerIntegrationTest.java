package com.example.BookStoreAPI.test;
import com.example.BookStoreAPI.entity.Customer;
import com.example.BookStoreAPI.repository.CustomerRepository;
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
public class CustomerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup() {
        // Clear the repository before each test
        customerRepository.deleteAll();
    }

    @Test
    public void testCreateAndRetrieveCustomer() throws Exception {
        String customerJson = "{\"name\":\"John Doe\",\"email\":\"john.doe@example.com\"}";

        // Test creating a new customer
        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));

        // Test retrieving the customer
        Customer savedCustomer = customerRepository.findAll().get(0);
        mockMvc.perform(get("/api/customers/" + savedCustomer.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        // Create a customer
        Customer customer = new Customer(null, "John Doe", "john.doe@example.com");
        customer = customerRepository.save(customer);

        // Update the customer
        String updatedCustomerJson = "{\"name\":\"Jane Doe\",\"email\":\"jane.doe@example.com\"}";
        mockMvc.perform(put("/api/customers/" + customer.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedCustomerJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane Doe"));

        // Verify the update
        mockMvc.perform(get("/api/customers/" + customer.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane Doe"));
    }

    @Test
    public void testDeleteCustomer() throws Exception {
        // Create a customer
        Customer customer = new Customer(null, "John Doe", "john.doe@example.com");
        customer = customerRepository.save(customer);

        // Delete the customer
        mockMvc.perform(delete("/api/customers/" + customer.getId()))
                .andExpect(status().isNoContent());

        // Verify the customer was deleted
        mockMvc.perform(get("/api/customers/" + customer.getId()))
                .andExpect(status().isNotFound());
    }
}

