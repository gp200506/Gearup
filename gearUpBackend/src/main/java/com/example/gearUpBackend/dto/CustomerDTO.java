package com.example.gearUpBackend.dto;

import lombok.Data;

@Data

public class CustomerDTO {
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
}