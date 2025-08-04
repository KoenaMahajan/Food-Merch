package com.amusement.foodmerch.service;

import com.amusement.foodmerch.model.MerchandiseItem;
import java.util.List;

public interface MerchandiseService {
    List<MerchandiseItem> getAllMerchandise();
    MerchandiseItem addMerchandise(MerchandiseItem item);
    void deleteMerchById(Long id);
}
