package com.minidwep.myshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.minidwep.myshop.entity.Payment;


public interface PaymentService extends IService<Payment> {

    boolean payment(Long orderId);
}
