package com.example.service;

public interface PaymentService {
	    void processPayment(int orderId, String paymentMethod);
	    String getPaymentStatus(int paymentId);
	    void updatePaymentStatus(int paymentId, String status);
	

}
