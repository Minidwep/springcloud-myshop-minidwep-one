package com.minidwep.myshop.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minidwep.myshop.entity.UserOrder;
import com.minidwep.myshop.entity.Payment;
import com.minidwep.myshop.mapper.OrderMapper;
import com.minidwep.myshop.mapper.PaymentMapper;
import com.minidwep.myshop.service.PaymentService;
import com.minidwep.myshop.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.SnowFlakeId;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {
    @Resource
    PaymentMapper paymentMapper;
    @Resource
    OrderMapper orderMapper;
    @Resource
    UserService userService;

    long workerId = 0;
    long datacenterId = 1L;

    @Override
    @Transactional
    public boolean payment(Long orderId) {
//        支付操作
//        1.查询是否有该订单且是否已经支付
        UserOrder order = orderMapper.selectById(orderId);
        if(order==null)
            return false;
        if(order.isStatus())
            return false;
//        2.新增支付表记录
        Payment payment = new Payment();
        long snowflakeId = SnowFlakeId.snowflakeId(workerId, datacenterId);
        payment.setId(snowflakeId);
        payment.setOrderId(orderId);
        payment.setPayTime(new Date());
        paymentMapper.insert(payment);
//        3.扣钱
        userService.disMoney(order.getUserId(), order.getPayMoney());
//        4.修改当前订单状态为1
        order.setStatus(true);
        orderMapper.updateById(order);
//        5.完成订单
        return true;
    }
}
