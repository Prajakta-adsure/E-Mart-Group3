package com.example.service;

import com.example.entity.Order;
import com.example.entity.User;

import java.util.List;

public interface OrderService {

    // Create a new order
    Order createOrder(Order order);

    // Get an order by its ID
    Order getOrderById(int orderId);

    // Get all orders placed by a user
    List<Order> getOrdersByUser(User user);

    // Get all orders
    List<Order> getAllOrders();
}
