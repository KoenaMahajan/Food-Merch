package com.amusement.foodmerch.repository;

import com.amusement.foodmerch.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {}
