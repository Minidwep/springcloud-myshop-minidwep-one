package com.minidwep.myshop.mapper;
import com.minidwep.myshop.entity.Msg;
import com.minidwep.myshop.entity.UserOrder;
import com.minidwep.myshop.service.CouponService;
import com.minidwep.myshop.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import util.SnowFlakeId;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Resource
    OrderService orderService;

    @Resource
    CouponService couponService;

    @Test
    void contextLoads() {
        UserOrder userOrder = new UserOrder();
        userOrder.setId(SnowFlakeId.snowflakeId(0L, 1L));
        userOrder.setBuyTime(new Date());
       orderService.placeOrder(userOrder);
    }
    @Test
    void test(){
        Msg msg = couponService.deleteCouponById(1L);
        System.out.println(msg);
    }


}
