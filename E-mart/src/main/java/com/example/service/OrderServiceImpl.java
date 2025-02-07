package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Order;
import com.example.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Order> getOrderById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        if (order.getOrderDetails() != null) {
            order.getOrderDetails().forEach(detail -> detail.setOrder(order));
        }
        if (order.getPaymentDetail() != null) {
            order.getPaymentDetail().setOrder(order);
        }
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order updateOrder(int id, Order orderDetails) {
        return orderRepository.findById(id).map(order -> {
            order.setOrderDate(orderDetails.getOrderDate());
            order.setTotalAmount(orderDetails.getTotalAmount());

            if (orderDetails.getOrderDetails() != null) {
                orderDetails.getOrderDetails().forEach(detail -> detail.setOrder(order));
                order.setOrderDetails(orderDetails.getOrderDetails());
            }
            if (orderDetails.getPaymentDetail() != null) {
                orderDetails.getPaymentDetail().setOrder(order);
                order.setPaymentDetail(orderDetails.getPaymentDetail());
            }
            return orderRepository.save(order);
        }).orElse(null);
    }

    @Override
    @Transactional
    public boolean deleteOrder(int id) {
        return orderRepository.findById(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
    }
}
