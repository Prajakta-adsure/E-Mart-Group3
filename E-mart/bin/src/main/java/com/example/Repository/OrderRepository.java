package com.example.repository;

import com.example.entity.Order;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Find an order by its ID
    Order findByOrderId(int orderId);

    // Find all orders by a specific user
    List<Order> findByUser(User user);

    // Find all orders (no filtering, just all orders)
    List<Order> findAll();
}
