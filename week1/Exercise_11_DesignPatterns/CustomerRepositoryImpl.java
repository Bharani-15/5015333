package com.Bharani.week1.Ex11;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        // In a real application, this would involve database access
        // Here we are just simulating with a dummy customer
        return new Customer(id, "John Doe");
    }
}

