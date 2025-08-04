package com.amusement.foodmerch.controller;

import com.amusement.foodmerch.model.MerchandiseItem;
import com.amusement.foodmerch.repository.MerchandiseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merch")
public class MerchandiseController {

    @Autowired private MerchandiseItemRepository merchRepo;

    @GetMapping("/store")
    public List<MerchandiseItem> getStoreItems() {
        return merchRepo.findAll();
    }

    @PostMapping("/add")
    public MerchandiseItem addMerch(@RequestBody MerchandiseItem item) {
        return merchRepo.save(item);
    }

    
}
