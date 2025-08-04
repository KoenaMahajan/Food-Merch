package com.amusement.foodmerch.controller;

import com.amusement.foodmerch.model.FoodItem;
import com.amusement.foodmerch.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired private FoodItemRepository foodRepo;

    @GetMapping("/menu")
    public List<FoodItem> getMenu() {
        return foodRepo.findAll();
    }

    @PostMapping("/add")
    public FoodItem addItem(@RequestBody FoodItem item) {
        return foodRepo.save(item);
    }
}
