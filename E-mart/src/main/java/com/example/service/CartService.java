package com.example.service;

import java.util.List;

import com.example.entity.Cart;
import com.example.entity.User;

public interface CartService 
{
	Cart addCart(Cart cart);
    Cart updateCart(int cartId, Cart cart);
    void deleteCart(int cartId);
    List<Cart> getAllCarts();
    Cart getCartById(int cartId);
    Cart addToCart(int userId, int productId, int quantity);
}
