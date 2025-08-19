package com.example.gearUpBackend.service;

import com.example.gearUpBackend.model.OrderItem;
import com.example.gearUpBackend.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepo;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepo.findAll();
    }
}