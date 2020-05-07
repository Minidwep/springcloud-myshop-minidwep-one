package com.minidwep.myshop.service;

import com.minidwep.myshop.entity.Msg;
import com.minidwep.myshop.entity.UserOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "${myshop.order-url}")
public interface OrderService {
    @PostMapping("/order")
     Msg placeOrder(UserOrder order);
    @GetMapping("/test")
     Msg test();
}
