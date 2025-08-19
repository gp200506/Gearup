package com.example.gearUpBackend.service;

import com.example.gearUpBackend.exception.BadRequestException;
import com.example.gearUpBackend.exception.ResourceNotFoundException;
import com.example.gearUpBackend.model.Customer;
import com.example.gearUpBackend.model.Order;
import com.example.gearUpBackend.model.OrderItem;
import com.example.gearUpBackend.repository.CustomerRepository;
import com.example.gearUpBackend.repository.OrderItemRepository;
import com.example.gearUpBackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;

    @Autowired
    private CustomerRepository customerRepo;

    public Order placeOrder(Long customerId, String deliveryAddress, List<OrderItem> items) {
        if (items == null || items.isEmpty()) {
            throw new BadRequestException("Order must contain at least one item");
        }

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        double total = items.stream()
                .mapToDouble(i -> i.getPriceAtPurchase() * i.getQuantity())
                .sum();

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(total);
        order.setDeliveryAddress(deliveryAddress);
        order.setItems(items);

        items.forEach(i -> i.setOrder(order));

        return orderRepo.save(order);
    }

    public List<Order> getOrders() {
        return orderRepo.findAll();
    }
}
