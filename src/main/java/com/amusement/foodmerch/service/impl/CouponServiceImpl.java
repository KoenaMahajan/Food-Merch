package com.amusement.foodmerch.service.impl;

import com.amusement.foodmerch.model.Coupon;
import com.amusement.foodmerch.repository.CouponRepository;
import com.amusement.foodmerch.service.CouponService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;

    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }
}
