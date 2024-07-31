package com.Bharani.week1.Ex11;

public class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(String id) {
        return customerRepository.findCustomerById(id);
    }
}

