package com.example.gearUpBackend.dto;

import lombok.Data;

@Data

public class CartItemDTO {
    private Long productId;
    private int quantity;
}