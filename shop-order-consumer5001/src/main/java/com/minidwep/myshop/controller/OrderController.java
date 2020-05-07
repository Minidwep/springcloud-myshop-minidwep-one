package com.minidwep.myshop.controller;

import com.minidwep.myshop.entity.Msg;
import com.minidwep.myshop.entity.UserOrder;
import com.minidwep.myshop.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    OrderService orderService;

    @PostMapping("/order")
    public Msg placeOrder(@RequestBody UserOrder order){
        Msg msg = orderService.placeOrder(order);
        return msg.getCode()==100?Msg.success():Msg.fail();
    }
    @GetMapping("/test")
    public Msg test(){
        Msg test = orderService.test();
        return test;
    }


}
