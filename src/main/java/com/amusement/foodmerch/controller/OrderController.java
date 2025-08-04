package com.amusement.foodmerch.controller;

import com.amusement.foodmerch.model.Order;
import com.amusement.foodmerch.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public Order placeOrder(@RequestBody Order order,
                            @RequestParam(required = false) String couponCode) {
        return orderService.placeOrder(order, couponCode);
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id,
                              @RequestParam String status) {
        return orderService.updateStatus(id, status); // Delegated
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId,
                                       @RequestParam(required = false) String status,
                                       @RequestParam(required = false, defaultValue = "asc") String sort) {
        return orderService.getOrdersByUserId(userId, status, sort);
    }

    @DeleteMapping("/{id}")
public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
    try {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok("Order with ID " + id + " deleted");
    } catch (RuntimeException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
}

}
