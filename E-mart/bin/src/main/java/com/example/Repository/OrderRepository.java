package com.example.repository;

import com.example.entity.Order;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transaction
public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Find all orders by a specific user
    List<Order> findByUser(User user);

    // Find all orders within a specific date range
    List<Order> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Find orders by their status (you can implement a status field in Order entity)
    List<Order> findByStatus(String status);
}
