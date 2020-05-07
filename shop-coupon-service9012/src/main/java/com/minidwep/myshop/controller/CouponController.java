package com.minidwep.myshop.controller;

import com.minidwep.myshop.entity.Coupon;
import com.minidwep.myshop.entity.Msg;
import com.minidwep.myshop.service.CouponService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CouponController {
    @Resource
    CouponService couponService;

    @GetMapping("/coupon/{id}")
    public Msg getCouponById(@PathVariable("id") Long id){
        Coupon coupon = couponService.getById(id);
        if(coupon == null){
            return Msg.fail();
        }
        return Msg.success().add("coupon", coupon);
    }

    @DeleteMapping("/coupon/{id}")
    public Msg deleteCouponById(@PathVariable("id") Long id){
        Coupon coupon = couponService.getById(id);
        if(coupon == null){
            return Msg.fail();
        }
        boolean flag = couponService.removeById(id);
        return flag?Msg.success():Msg.fail();
    }
}
