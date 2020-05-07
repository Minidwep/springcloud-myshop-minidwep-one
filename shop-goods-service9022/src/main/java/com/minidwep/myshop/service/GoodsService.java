package com.minidwep.myshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.minidwep.myshop.entity.Goods;

public interface GoodsService extends IService<Goods> {
    boolean minusGoods(int goodsId);

    boolean minusSecKilGoods(int goodsId);
}
