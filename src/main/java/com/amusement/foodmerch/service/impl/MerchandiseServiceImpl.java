package com.amusement.foodmerch.service.impl;

import com.amusement.foodmerch.model.MerchandiseItem;
import com.amusement.foodmerch.repository.MerchandiseItemRepository;
import com.amusement.foodmerch.service.MerchandiseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchandiseServiceImpl implements MerchandiseService {

    @Autowired
    private MerchandiseItemRepository merchRepo;

    @Override
    public void deleteMerchById(Long id) {
        if (merchRepo.existsById(id)) {
            merchRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("Merchandise with ID " + id + " not found.");
        }
    }

    @Override
    public List<MerchandiseItem> getAllMerchandise() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllMerchandise'");
    }

    @Override
    public MerchandiseItem addMerchandise(MerchandiseItem item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMerchandise'");
    }
}
