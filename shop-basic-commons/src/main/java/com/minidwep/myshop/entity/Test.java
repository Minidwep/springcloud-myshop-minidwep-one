package com.minidwep.myshop.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        SeckillGoods seckillGoods = new SeckillGoods();
        seckillGoods.setId(1);
        seckillGoods.setAdvanceTime(new Date());
        seckillGoods.setFinalTime(new Date(new Date().getTime() + 600000));
        seckillGoods.setName("测试商品");
        seckillGoods.setPrice(new BigDecimal(12.3));
        System.out.println(seckillGoods.toString());
    }
}
