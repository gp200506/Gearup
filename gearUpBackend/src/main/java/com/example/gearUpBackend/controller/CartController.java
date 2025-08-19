package com.example.gearUpBackend.controller;

import com.example.gearUpBackend.model.*;
import com.example.gearUpBackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{customerId}")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Long customerId) {
        return ResponseEntity.ok(cartService.getCartItems(customerId));
    }

    @PostMapping("/add")
    public ResponseEntity<CartItem> addToCart(@RequestParam Long customerId,
                                              @RequestParam Long productId,
                                              @RequestParam int quantity) {
        return new ResponseEntity<>(cartService.addToCart(customerId, productId, quantity), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
        return ResponseEntity.noContent().build();
    }
}