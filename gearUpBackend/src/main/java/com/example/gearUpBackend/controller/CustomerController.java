package com.example.gearUpBackend.controller;

import com.example.gearUpBackend.config.JwtUtil;
import com.example.gearUpBackend.dto.LoginRequestDTO;
import com.example.gearUpBackend.dto.LoginResponse;
import com.example.gearUpBackend.model.Customer;
import com.example.gearUpBackend.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;
    private final JwtUtil jwtUtil;

    public CustomerController(CustomerService customerService, JwtUtil jwtUtil) {
        this.customerService = customerService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer customer) {
        Customer saved = customerService.saveCustomer(customer);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        return customerService.authenticate(loginRequest.getEmail(), loginRequest.getPassword())
                .<ResponseEntity<?>>map(customer -> {
                    String token = jwtUtil.generateToken(customer.getEmail());
                    return ResponseEntity.ok(new LoginResponse(customer, token));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Invalid email or password"));
    }
}
