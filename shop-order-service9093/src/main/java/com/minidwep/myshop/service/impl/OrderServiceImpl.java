package com.minidwep.myshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minidwep.myshop.entity.Msg;
import com.minidwep.myshop.entity.Payment;
import com.minidwep.myshop.entity.UserOrder;
import com.minidwep.myshop.mapper.OrderMapper;
import com.minidwep.myshop.service.CouponService;
import com.minidwep.myshop.service.OrderService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.SnowFlakeId;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, UserOrder>implements OrderService {
    @Resource
    OrderMapper orderMapper;
    @Resource
    CouponService couponService;

    @Override
    @Transactional
    public boolean placeOrder(UserOrder order) {
//        1.确认账号下是否存在优惠券，如果有删除优惠券
        Msg msg = couponService.deleteCouponById(order.getCouponId());
        if(msg.getCode() == 200)
            return false;
//        2.生成订单
        orderMapper.insert(order);
        return true;
    }


}
