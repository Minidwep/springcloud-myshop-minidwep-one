package com.minidwep.myshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.minidwep.myshop.entity.UserOrder;


public interface OrderService  extends IService<UserOrder> {
    boolean placeOrder(UserOrder order);
}
