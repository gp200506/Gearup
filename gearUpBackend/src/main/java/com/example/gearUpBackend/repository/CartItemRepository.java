package com.example.gearUpBackend.repository;

import com.example.gearUpBackend.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCustomerId(Long customerId);
}
