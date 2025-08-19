package com.example.gearUpBackend.dto;

import lombok.Data;

@Data

public class OrderItemDTO {
    private Long productId;
    private int quantity;
    private double priceAtPurchase;
}