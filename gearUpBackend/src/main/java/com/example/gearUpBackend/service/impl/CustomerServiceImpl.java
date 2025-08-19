package com.example.gearUpBackend.service.impl;

import com.example.gearUpBackend.model.Customer;
import com.example.gearUpBackend.repository.CustomerRepository;
import com.example.gearUpBackend.config.JwtUtil;
import com.example.gearUpBackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> authenticate(String email, String password) {
        return customerRepository.findByEmail(email)
                .filter(c -> c.getPassword().equals(password));
    }

    @Override
    public String generateToken(Customer customer) {
        return jwtUtil.generateToken(customer.getEmail());
    }
}
