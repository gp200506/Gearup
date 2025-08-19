package com.example.gearUpBackend.dto;

import com.example.gearUpBackend.model.Customer;
import lombok.Data;

@Data
public class LoginResponse {
    private Customer customer;
    private String token;

    public LoginResponse(Customer customer, String token) {
        this.customer = customer;
        this.token = token;
    }
}
