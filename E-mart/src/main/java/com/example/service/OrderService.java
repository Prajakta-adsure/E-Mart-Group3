package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Order;

public interface OrderService {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(int id);
    Order createOrder(Order order);
    Order updateOrder(int id, Order orderDetails);
    boolean deleteOrder(int id);
}
