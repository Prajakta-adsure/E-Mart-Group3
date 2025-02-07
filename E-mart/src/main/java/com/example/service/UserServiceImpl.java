package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.RegisterRequest;
import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public User registerUser(RegisterRequest registerRequest) {
    	
    	User user = new User();
    	user.setName(registerRequest.getName());
    	user.setMobileNumber(registerRequest.getMobileNumber());
    	user.setEmail(registerRequest.getEmail());
    	user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));// Hashing password
        return userRepository.save(user); // Save user in the repository
    }

    @Override
    public String loginUser(String email, String password) {
        // Find the user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // Compare the entered password with the stored hashed password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return "Login successful"; // Return success message if login is successful
    }

    @Override
    public User updateUser(Integer userId, User user) {
        // Find the existing user by ID
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the email is already in use by another user
        if (!existingUser.getEmail().equals(user.getEmail()) &&
                userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        // Update user details
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser); // Save the updated user
    }

    @Override
    public boolean deleteUser(Integer userId) {
        // Find the user by ID and delete if exists
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            userRepository.delete(user); // Delete user from repository
            return true; // Return true if the user was deleted successfully
        }
        return false; // Return false if the user was not found
    }

    @Override
    public Optional<User> getUserDetails(Integer userId) {
        // Fetch user details by ID from repository
        return userRepository.findById(userId); 
    }

    @Override
    public User getUserCart(Integer userId) {
        // Implement logic to get the user's cart if required (e.g., through a relationship with Cart entity)
        // Example placeholder code, assuming a relationship exists with a Cart entity
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user; // Or return the cart details related to the user if implemented
    }
}
