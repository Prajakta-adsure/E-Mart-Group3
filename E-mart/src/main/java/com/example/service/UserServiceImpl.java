package com.example.service;

import java.util.List;
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
	public User CreateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserByID(long id) {
		 Optional<User> user = userRepository.findById((int) id);
		 return user.orElse(null);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById((int) id);
	}

	@Override
	public User updateUser(long id, User userDetails) {
		 Optional<User> optionalUser = userRepository.findById((int) id); // Assuming ID is Integer, change accordingly
	        
	        if (optionalUser.isPresent()) {
	            User user = optionalUser.get();
	            
	            // Update user fields with new details (example, update name, email, etc.)
	            user.setName(userDetails.getName());
	            user.setEmail(userDetails.getEmail());
	            
	            
	            // Save the updated user
	            return userRepository.save(user);
	        } else {
	            // User not found, return null or handle exception as needed
	            return null; 
	        }
	}

}
