package com.minidwep.myshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minidwep.myshop.entity.Coupon;
import com.minidwep.myshop.entity.UserOrder;
import com.minidwep.myshop.mapper.CouponMapper;
import com.minidwep.myshop.service.CouponService;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {
}
