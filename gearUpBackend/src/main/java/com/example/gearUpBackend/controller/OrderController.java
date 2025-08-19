package com.example.gearUpBackend.controller;

import com.example.gearUpBackend.model.Order;
import com.example.gearUpBackend.model.OrderItem;
import com.example.gearUpBackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<Order> placeOrder(@RequestParam Long customerId,
                                            @RequestParam String deliveryAddress,
                                            @RequestBody List<OrderItem> items) {
        Order order = orderService.placeOrder(customerId, deliveryAddress, items);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }
}
