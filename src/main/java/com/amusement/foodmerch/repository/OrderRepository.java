package com.amusement.foodmerch.repository;

import com.amusement.foodmerch.model.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);

    List<Order> findByUserIdAndStatusIgnoreCase(Long userId, String status);


}

