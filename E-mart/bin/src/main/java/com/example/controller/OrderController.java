package com.example.controller;

import com.example.entity.Order;
import com.example.entity.PaymentDetail;
import com.example.entity.User;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Create a new order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // Get an order by its ID
    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable int orderId) {
        return orderService.getOrderById(orderId);
    }

    // Get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Update an existing order
    @PutMapping("/{orderId}")
    public Order updateOrder(@PathVariable int orderId, @RequestBody Order updatedOrder) {
        return orderService.updateOrder(orderId, updatedOrder);
    }

    // Delete an order
    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable int orderId) {
        orderService.deleteOrder(orderId);
    }

    // Get all orders placed by a user
    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable int userId) {
        // Assuming the User exists with the given ID
        User user = new User(); // Find user by userId (implement a UserService for user fetching)
        user.setId(userId);
        return orderService.getOrdersByUser(user);
    }

    // Get orders within a specific date range
    @GetMapping("/date-range")
    public List<Order> getOrdersByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        return orderService.getOrdersByDateRange(start, end);
    }

    // Get orders by their status
    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable String status) {
        return orderService.getOrdersByStatus(status);
    }

    // Calculate the total amount for an order
    @GetMapping("/calculate-total/{orderId}")
    public double calculateTotalAmount(@PathVariable int orderId) {
        Order order = orderService.getOrderById(orderId);
        return orderService.calculateTotalAmount(order);
    }

    // Place an order with payment details
    @PostMapping("/place-order")
    public Order placeOrder(@RequestBody Order order, @RequestBody PaymentDetail paymentDetail) {
        return orderService.placeOrder(order, paymentDetail);
    }

    // Cancel an order
    @PutMapping("/cancel/{orderId}")
    public Order cancelOrder(@PathVariable int orderId) {
        return orderService.cancelOrder(orderId);
    }
}
