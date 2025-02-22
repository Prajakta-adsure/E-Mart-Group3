package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.config.UserPrincipal;
import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<User> optionalUser = userRepository.findByEmail(email);
		
		if(optionalUser.isPresent()) {
			return new UserPrincipal(optionalUser.get());
		} else {
			throw new UsernameNotFoundException("User not found");
		}

	}

}
