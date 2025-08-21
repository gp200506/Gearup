package com.example.gearUpBackend.service;

import com.example.gearUpBackend.model.Customer;
import java.util.Optional;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Optional<Customer> getCustomer(Long id);
    Optional<Customer> authenticate(String email, String password);
    String generateToken(Customer customer); // New method for token
    Customer getByEmail(String email);
}
