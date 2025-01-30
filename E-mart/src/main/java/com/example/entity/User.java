package com.example.entity;

import java.util.List;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotBlank(message = "Name is required")
    private String name;

    // Mobile number should be a 10-digit number
    @Column(unique = true, length = 10)
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be a 10-digit number")
    private String mobileNumber;

    // Email should follow the correct email format
    @Column(unique = true)
    @Email(message = "Please provide a valid email address")
    private String email;
    
    @Column(name = "address", length = 255)
    private String address;
    
    @NotBlank(message = "Password is required")
    private String password;

    private String creditCardInfo;
    
    private String internetBankingInfo;
    
    private boolean isMember;


//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
//    private List<Order> orders;


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreditCardInfo() {
		return creditCardInfo;
	}

	public void setCreditCardInfo(String creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}

	public String getInternetBankingInfo() {
		return internetBankingInfo;
	}

	public void setInternetBankingInfo(String internetBankingInfo) {
		this.internetBankingInfo = internetBankingInfo;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email
				+ ", address=" + address + ", password=" + password + ", creditCardInfo=" + creditCardInfo
				+ ", internetBankingInfo=" + internetBankingInfo + ", isMember=" + isMember + "]";
	}

	
	

//	public List<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}

	
	
	

    
}
