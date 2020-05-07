package com.minidwep.myshop.controler;

import com.minidwep.myshop.entity.Msg;

import com.minidwep.myshop.service.PaymentService;
import com.minidwep.myshop.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {
    @Resource
    TestService testService;
    @Resource
    PaymentService paymentService;

    @GetMapping("/payment/{orderId}")
    public Msg paymentGoods(@PathVariable("orderId") Long orderId){
        boolean flag = paymentService.payment(orderId);
        return flag?Msg.success():Msg.fail();
    }

    @GetMapping("test")
    public Msg test(){
        testService.Test();
        return Msg.success();
    }
}
