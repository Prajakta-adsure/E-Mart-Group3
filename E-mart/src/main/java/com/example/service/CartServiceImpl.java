package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.repository.CartRepository;
import com.example.repository.ProductRepository;
import com.example.repository.UserRepository;

public class CartServiceImpl implements CartService
{
	 @Autowired
	    private CartRepository cartRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	   private ProductRepository productRepository;


	@Override
	public Cart addCart(Cart cart) {
	    return cartRepository.save(cart);
	}

	@Override
	public Cart updateCart(int cartId, Cart cart) {
		// Fetch the existing cart using cartId
	    Cart existingCart = cartRepository.findById(cartId)
	            .orElseThrow(() -> new RuntimeException("Cart with ID " + cartId + " not found."));

	    // Update the existing cart with the new values from the provided cart
	    existingCart.setQuantity(cart.getQuantity());  
	    existingCart.setProduct(cart.getProduct());    

	    // Save the updated cart and return it
	    return cartRepository.save(existingCart);
	}

	@Override
	public void deleteCart(int cartId) {
		Cart existingCart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart with ID " + cartId + " not found."));
        cartRepository.delete(existingCart);
		
	}

	@Override
	public List<Cart> getAllCarts() {
		return cartRepository.findAll();
	}

	@Override
	public Cart getCartById(int cartId) {
		return cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart with ID " + cartId + " not found."));
	}

	@Override
	public Cart addToCart(int userId, int productId, int quantity) {
		User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found."));

        // Fetch the Product by ID
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product with ID " + productId + " not found."));

        // Check if the product already exists in the user's cart
        Optional<Cart> existingCart = cartRepository.findByUserAndProduct(user, product);
        if (existingCart.isPresent()) {
            // If the product exists, update the quantity
            Cart cart = existingCart.get();
            cart.setQuantity(cart.getQuantity() + quantity);
            return cartRepository.save(cart);
        }

        // If the product is not in the cart, create a new entry
        Cart newCart = new Cart();
        newCart.setUser(user);
        newCart.setProduct(product);
        newCart.setQuantity(quantity);
        return cartRepository.save(newCart);
    }
}

	
	




