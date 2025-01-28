package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface UserService {
	User CreateUser(User user);
	User getUserByID(long id);
	List <User> getAllUser();
	void deleteUser(long id);
	User updateUser(long id, User userDetails);

}
