package com.minidwep.myshop.controller;

import com.minidwep.myshop.entity.Goods;
import com.minidwep.myshop.entity.Msg;
import com.minidwep.myshop.service.GoodsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GoodsController {

    @Resource
    GoodsService goodsService;
    @PutMapping("/goods/{id}")
    public Msg minusGoods(@PathVariable("id") int id){
        boolean flag = goodsService.minusGoods(id);
        Goods byId = goodsService.getById(id);
        int stock = byId.getStock();
        return flag?Msg.success().add("str", "库存还有"+stock):Msg.fail().add("str", "卖完了OVO");
    }
    @PutMapping("/goods/seckill/{id}")
    public Msg minusSecKilGoods(@PathVariable("id") int id){
        boolean flag = goodsService.minusSecKilGoods(id);
        Goods byId = goodsService.getById(id);
        int stock = byId.getStock();
        return flag?Msg.success().add("str", "库存还有"+stock):Msg.fail().add("str", "卖完了OVO");
    }

}
