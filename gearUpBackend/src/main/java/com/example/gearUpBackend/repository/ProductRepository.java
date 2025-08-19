package com.example.gearUpBackend.repository;
import com.example.gearUpBackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
