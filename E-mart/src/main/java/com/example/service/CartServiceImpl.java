package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.repository.CartRepository;
@Service
public class CartServiceImpl implements CartService{

	@Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addToCart(User user, Product product, int quantity) {
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProduct(product);
        cart.setQuantity(quantity);
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(int cartId, int quantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.setQuantity(quantity);
        return cartRepository.save(cart);
    }

    @Override
    public void removeProductFromCart(int cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public List<Cart> getUserCart(User user) {
        return cartRepository.findByUser(user);
    }

}
