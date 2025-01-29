package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Cart;
import com.example.entity.User;
import com.example.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    
    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(
            @RequestParam int userId,
            @RequestParam int productId,
            @RequestParam int quantity) {
        Cart savedCart = cartService.addToCart(userId, productId, quantity);
        return ResponseEntity.ok(savedCart);
    }

    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Cart>> getUserCarts(@PathVariable int userId) {
        List<Cart> userCarts = cartService.getAllCarts(); // You may need to filter by userId in service
        return ResponseEntity.ok(userCarts);
    }

    
    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable int cartId) {
        Cart cart = cartService.getCartById(cartId);
        return ResponseEntity.ok(cart);
    }

    
    @PutMapping("/update/{cartId}")
    public ResponseEntity<Cart> updateCart(
            @PathVariable int cartId,
            @RequestBody Cart cartDetails) {
        Cart updatedCart = cartService.updateCart(cartId, cartDetails);
        return ResponseEntity.ok(updatedCart);
    }

    
    @DeleteMapping("/remove/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable int cartId) {
        cartService.deleteCart(cartId);
        return ResponseEntity.noContent().build();
    }
}