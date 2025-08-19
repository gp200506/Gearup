package com.example.gearUpBackend.repository;
import com.example.gearUpBackend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}