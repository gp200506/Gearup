package com.example.gearUpBackend.service;

import com.example.gearUpBackend.exception.ResourceNotFoundException;
import com.example.gearUpBackend.model.Product;
import com.example.gearUpBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
}
