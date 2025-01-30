package com.example.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	 @Autowired
	 private UserService userService;

	    // Register a new user
	    @PostMapping("/register")
	    public User registerUser(@RequestBody User user) {
	        return userService.registerUser(user);
	    }

	    // Login user
	    @PostMapping("/login")
	    public String loginUser(@RequestParam String email, @RequestParam String password) {
	        try {
	            return userService.loginUser(email, password);
	        } catch (RuntimeException e) {
	            return e.getMessage();
	        }
	    }

	    // Update user details
	    @PutMapping("/{userId}")
	    public User updateUser(@PathVariable Integer userId, @RequestBody User user) {
	        return userService.updateUser(userId, user);
	    }

	    // Delete user
	    @DeleteMapping("/{userId}")
	    public String deleteUser(@PathVariable Integer userId) {
	        userService.deleteUser(userId);
	        return "User deleted successfully";
	    }

	    // Get user details by userId
	    @GetMapping("/{userId}")
	    public User getUserDetails(@PathVariable Integer userId) {
	        return userService.getUserDetails(userId);
	    }

	    // Get user cart by userId
	    @GetMapping("/{userId}/cart")
	    public User getUserCart(@PathVariable Integer userId) {
	        return userService.getUserCart(userId);
	    }
   
}
