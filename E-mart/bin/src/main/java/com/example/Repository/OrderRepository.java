package com.example.repository;

import com.example.entity.Order;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Find all orders by a specific user
    List<Order> findByUser(User user);

    // Find all orders within a specific date range
    List<Order> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Find orders by their status (Assumes that Order entity has a "status" field)
    List<Order> findByStatus(String status);
    
    // Find orders by status and user
    List<Order> findByUserAndStatus(User user, String status);
    
    // Find orders by status and date range
    List<Order> findByStatusAndOrderDateBetween(String status, LocalDateTime startDate, LocalDateTime endDate);
    
    // Find orders by user and date range
    List<Order> findByUserAndOrderDateBetween(User user, LocalDateTime startDate, LocalDateTime endDate);
}
