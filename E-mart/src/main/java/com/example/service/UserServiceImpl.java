package com.example.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
    private UserRepository userRepository;
	
	
	
	


	@Override
	public User registerUser(User user) {
	return userRepository.save(user);
	}

	@Override
	public String loginUser(String email, String password) {
		Optional<User> userOpt = userRepository.findByEmail(email);
		if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) { // No password validation
            return "Login successful";
	    }
	    throw new RuntimeException("Invalid email or password");
	}

	@Override
	public User updateUser(Integer userId, User user) {
		User existingUser = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    existingUser.setName(user.getName());  // Use the passed user object
	    existingUser.setEmail(user.getEmail());
	    return userRepository.save(existingUser);

	}

	@Override
	public void deleteUser(Integer userId) {
		User user = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));
	    userRepository.delete(user);

		
	}

	@Override
	public User getUserDetails(Integer userId) {
		 return userRepository.findById(userId)
		            .orElseThrow(() -> new RuntimeException("User not found"));

	}

	@Override
	public User getUserCart(Integer userId) {
		return userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	}
	
	
	
}
