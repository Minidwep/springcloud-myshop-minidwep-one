package com.minidwep.myshop.service;

import com.minidwep.myshop.entity.Msg;
import com.minidwep.myshop.entity.UserOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "${myshop.goods-url}")
public interface GoodsService {
    @PutMapping("/goods/{id}")
    Msg minusGoods(@PathVariable("id") int id);

    @PutMapping("/goods/seckill/{id}")
    Msg minusSecKilGoods(@PathVariable("id") int id);
}
