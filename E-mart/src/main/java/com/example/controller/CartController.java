package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public Cart addToCart(@RequestParam User user, @RequestParam Product product, @RequestParam int quantity) {
        return cartService.addToCart(user, product, quantity);
    }

    @PutMapping("/update/{cartId}")
    public Cart updateCart(@PathVariable int cartId, @RequestParam int quantity) {
        return cartService.updateCart(cartId, quantity);
    }

    @DeleteMapping("/remove/{cartId}")
    public void removeProductFromCart(@PathVariable int cartId) {
        cartService.removeProductFromCart(cartId);
    }

    @GetMapping("/user")
    public List<Cart> getUserCart(@RequestParam User user) {
        return cartService.getUserCart(user);
    }
}