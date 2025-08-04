package com.amusement.foodmerch.controller;

import com.amusement.foodmerch.model.Coupon;
import com.amusement.foodmerch.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping
    public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon) {
        Coupon saved = couponService.createCoupon(coupon);
        return ResponseEntity.ok(saved);
    }
}
