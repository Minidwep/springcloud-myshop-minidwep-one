package com.minidwep.myshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.minidwep.myshop.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
    @Override
    int insert(@Param("payment") Payment entity);
}
