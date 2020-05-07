package com.minidwep.myshop.mapper;
import com.minidwep.myshop.entity.Msg;
import com.minidwep.myshop.entity.UserOrder;
import com.minidwep.myshop.service.PaymentService;
import com.minidwep.myshop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import util.SnowFlakeId;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
class ApplicationTests {

    @Resource
    UserService userService;

    @Test
    void contextLoads() {
        userService.disMoney(1,new BigDecimal(10));

    }



}
