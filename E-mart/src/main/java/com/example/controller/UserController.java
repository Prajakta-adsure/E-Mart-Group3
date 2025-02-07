package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.example.dto.JwtResponse;
import com.example.dto.RegisterRequest;
import com.example.entity.User;
import com.example.security.JwtUtil;
import com.example.service.CustomUserDetailsService;
import com.example.service.UserService;

@RestController//making it suitable for RESTful APIs. It combines @Controller and @ResponseBody annotations.
@RequestMapping("/users")//this define the base url for all endpoint in this controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService customuserdetailsservice;

	@Autowired
	private JwtUtil jwtutil;

	// Register a new user
	@CrossOrigin(origins = "http://localhost:3000")//request
	@PostMapping("/register")//mappps the request
	public User registerUser(@RequestBody RegisterRequest user) {//@requestbody RegisterRequest user: contain register request object
		return userService.registerUser(user);//calls userservice
	}

	// Login user
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {//parameters are passes as query parameter in the request (/login?email=email@example.com&password=secret)
		System.out.println("JWT wdhvfjhvfhjvhfvs");
		    //This Authenticate the user and create authentication object(Token)
			authenticationManager.authenticate(UsernamePasswordAuthenticationToken.unauthenticated(email, password));
			
				UserDetails userdetails = customuserdetailsservice.loadUserByUsername(email);
				//as per authentication details it will generate JWT token
				String token = this.jwtutil.generateToken(userdetails);
				System.out.println("JWT " + token);
				return ResponseEntity.ok(new JwtResponse(token));//return http response with 200 ok status also contains jwt token inside jwtresponse object
		
	}

	// Update user details
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable Integer userId, @RequestBody User user) {
		return userService.updateUser(userId, user);
	}

	// Delete user
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable Integer userId) {
		boolean isDeleted = userService.deleteUser(userId);
		return isDeleted ? "User deleted successfully" : "User deletion failed";
	}

	// Get user details by userId
	@GetMapping("/{userId}")
	public User getUserDetails(@PathVariable Integer userId) {
		return userService.getUserDetails(userId).orElseThrow(() -> new RuntimeException("User not found"));
	}
}
