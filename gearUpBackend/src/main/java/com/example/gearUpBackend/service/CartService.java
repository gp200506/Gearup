package com.example.gearUpBackend.service;

import com.example.gearUpBackend.exception.BadRequestException;
import com.example.gearUpBackend.exception.ResourceNotFoundException;
import com.example.gearUpBackend.model.CartItem;
import com.example.gearUpBackend.model.Customer;
import com.example.gearUpBackend.model.Product;
import com.example.gearUpBackend.repository.CartItemRepository;
import com.example.gearUpBackend.repository.CustomerRepository;
import com.example.gearUpBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ProductRepository productRepo;

    public List<CartItem> getCartItems(Long customerId) {
        return cartRepo.findByCustomerId(customerId);
    }

    public CartItem addToCart(Long customerId, Long productId, int quantity) {
        if (quantity <= 0) {
            throw new BadRequestException("Quantity must be greater than 0");
        }

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        CartItem item = new CartItem();
        item.setCustomer(customer);
        item.setProduct(product);
        item.setQuantity(quantity);

        return cartRepo.save(item);
    }

    public void removeFromCart(Long cartItemId) {
        cartRepo.findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found"));
        cartRepo.deleteById(cartItemId);
    }
}
