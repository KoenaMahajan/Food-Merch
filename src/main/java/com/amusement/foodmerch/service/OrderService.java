package com.amusement.foodmerch.service;

import com.amusement.foodmerch.model.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(Order order, String couponCode);
    Order getOrderById(Long id);
    List<Order> getOrdersByUserId(Long userId, String status, String sort);
    Order updateStatus(Long id, String status);
    void deleteOrderById(Long id); // Optional, included for completeness
}
