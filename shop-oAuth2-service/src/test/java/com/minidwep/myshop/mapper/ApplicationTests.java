package com.minidwep.myshop.mapper;

import com.minidwep.myshop.domain.TbPermission;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Resource
    TbPermissionMapper tbPermissionMapper;
    @Test
    void contextLoads() {
        List<TbPermission> tbPermissions = tbPermissionMapper.selectByUserId(37);
        System.out.println(tbPermissions.size());
    }



}
