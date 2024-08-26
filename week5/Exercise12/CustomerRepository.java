package com.example.BookStoreAPI.repository;

import com.example.BookStoreAPI.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}

