package com.minidwep.myshop.controller;

import com.minidwep.myshop.entity.Msg;
import com.minidwep.myshop.entity.UserOrder;
import com.minidwep.myshop.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
public class OrderController {

    @Resource
    OrderService orderService;

    @Value("${server.port}")
    String port;
    @PostMapping("/order")
    public Msg placeOrder(UserOrder order){
        boolean flag = orderService.placeOrder(order);
        ArrayList arrayList = new ArrayList();
        return flag?Msg.success().add("port",port):Msg.fail().add("port",port);
    }
    @GetMapping("/test")
    public Msg test(){
        return Msg.success().add("port", port);
    }

}
