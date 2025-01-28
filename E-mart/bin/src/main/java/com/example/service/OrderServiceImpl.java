package com.example.service.impl;

import com.example.entity.Order;
import com.example.entity.PaymentDetail;
import com.example.entity.User;
import com.example.repository.OrderRepository;
import com.example.repository.PaymentDetailRepository;
import com.example.repository.UserRepository;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentDetailRepository paymentDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Order createOrder(Order order) {
        // Optionally, you can calculate the total amount or perform other logic before saving
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(int orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order.orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(int orderId, Order updatedOrder) {
        Optional<Order> existingOrderOpt = orderRepository.findById(orderId);
        if (existingOrderOpt.isPresent()) {
            Order existingOrder = existingOrderOpt.get();
            // Update fields of existing order with the updated values
            existingOrder.setOrderDate(updatedOrder.getOrderDate());
            existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
            existingOrder.setOrderDetails(updatedOrder.getOrderDetails());
            existingOrder.setPaymentDetail(updatedOrder.getPaymentDetail());
            return orderRepository.save(existingOrder);
        } else {
            throw new RuntimeException("Order not found with id: " + orderId);
        }
    }

    @Override
    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findByUser(user);
    }

    @Override
    public List<Order> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return orderRepository.findByOrderDateBetween(startDate, endDate);
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        // Assuming you have a status field in Order (you may need to implement this)
        return orderRepository.findByStatus(status);
    }

    @Override
    public double calculateTotalAmount(Order order) {
        // Calculate the total amount for the order, assuming you have OrderDetails for items
        return order.getOrderDetails().stream()
                .mapToDouble(detail -> detail.getPrice() * detail.getQuantity()) // Assuming OrderDetails have price and quantity
                .sum();
    }

    @Override
    public Order placeOrder(Order order, PaymentDetail paymentDetail) {
        // Link the payment details to the order and place it
        order.setPaymentDetail(paymentDetail);
        paymentDetailRepository.save(paymentDetail);
        return createOrder(order);
    }

    @Override
    public Order cancelOrder(int orderId) {
        Order order = getOrderById(orderId);
        // Handle order cancellation logic (e.g., updating status, etc.)
        order.setOrderDate(null);  // Example: setting order date to null as a sign of cancellation
        return orderRepository.save(order);
    }
}
