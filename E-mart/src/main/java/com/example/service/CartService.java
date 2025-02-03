package com.example.service;

import java.util.List;

import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.entity.User;

public interface CartService {
	
    Cart addToCart(User user, Product product, int quantity);
    Cart updateCart(int cartId, int quantity);
    void removeProductFromCart(int cartId);
    List<Cart> getUserCart(User user);

}
