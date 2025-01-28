package com.example.service;

import com.example.entity.Order;
import com.example.entity.PaymentDetail;
import com.example.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    // Create a new order
    Order createOrder(Order order);

    // Get an order by its ID
    Order getOrderById(int orderId);

    // Get a list of all orders
    List<Order> getAllOrders();

    // Update an existing order
    Order updateOrder(int orderId, Order updatedOrder);

    // Delete an order
    void deleteOrder(int orderId);

    // Get all orders placed by a user
    List<Order> getOrdersByUser(User user);

    // Get orders placed within a specific date range
    List<Order> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    // Get orders by their status
    List<Order> getOrdersByStatus(String status);

    // Calculate the total amount of an order
    double calculateTotalAmount(Order order);

    // Place the order and link to payment details
    Order placeOrder(Order order, PaymentDetail paymentDetail);

    // Cancel an order
    Order cancelOrder(int orderId);

    // Get a user by ID
    User getUserById(int userId);
}
