package com.minidwep.myshop.service;

import com.minidwep.myshop.entity.Msg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "${myshop.coupon-url}")
public interface CouponService {
    @DeleteMapping("/coupon/{id}")
     Msg deleteCouponById(@PathVariable("id") Long id);
}
