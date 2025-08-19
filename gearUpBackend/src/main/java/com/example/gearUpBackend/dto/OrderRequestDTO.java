package com.example.gearUpBackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {
    private Long customerId;
    private String deliveryAddress;
    private List<OrderItemDTO> items;
}
