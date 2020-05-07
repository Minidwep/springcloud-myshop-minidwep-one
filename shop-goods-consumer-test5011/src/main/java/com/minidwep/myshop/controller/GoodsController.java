package com.minidwep.myshop.controller;

import com.minidwep.myshop.entity.Goods;
import com.minidwep.myshop.entity.Msg;
import com.minidwep.myshop.entity.UserOrder;
import com.minidwep.myshop.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class GoodsController {

    @Resource
    GoodsService goodsService;

    @PutMapping("/goods/{id}")
    public Msg placeOrder(@PathVariable("id") int id){
        Msg msg = goodsService.minusGoods(id);
        return msg;
    }

    @PutMapping("/goods/seckill/{id}")
    public Msg minusSecKilGoods(@PathVariable("id") int id){
        Msg msg = goodsService.minusSecKilGoods(id);
        return msg;
    }



}
