package com.example.service;
import com.example.entity.User;

public interface UserService {
	 User registerUser(User user);
	 String loginUser(String email, String password);
	 User updateUser(Integer userId, User user);
	 void deleteUser(Integer userId);
	 User getUserDetails(Integer userId);
	 User getUserCart(Integer userId);

    

}
