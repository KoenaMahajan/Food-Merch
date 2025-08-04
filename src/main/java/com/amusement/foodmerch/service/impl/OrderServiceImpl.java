package com.amusement.foodmerch.service.impl;

import com.amusement.foodmerch.model.Order;
import com.amusement.foodmerch.repository.OrderRepository;
import com.amusement.foodmerch.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order placeOrder(Order order, String couponCode) {
        // Coupon logic can be applied here if needed
        // For now, just saving the order
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId, String status, String sort) {
        List<Order> orders = orderRepository.findByUserId(userId);

        // Filter by status if provided
        if (status != null && !status.trim().isEmpty()) {
            orders = orders.stream()
                    .filter(order -> status.equalsIgnoreCase(order.getStatus()))
                    .collect(Collectors.toList());
        }

        // Sort based on ID (or customize based on another field)
        Comparator<Order> comparator = Comparator.comparing(Order::getId);
        if ("desc".equalsIgnoreCase(sort)) {
            comparator = comparator.reversed();
        }

        return orders.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public Order updateStatus(Long id, String status) {
        Order order = getOrderById(id);
        order.setStatus(status.trim());
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order with ID " + id + " does not exist.");
        }
        orderRepository.deleteById(id);
    }
}
