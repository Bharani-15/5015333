package com.Bharani.week1.Ex11;

public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create a CustomerRepository implementation
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the CustomerRepository into CustomerService
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        Customer customer = customerService.getCustomerById("123");

        // Display the customer details
        System.out.println(customer);
    }
}

