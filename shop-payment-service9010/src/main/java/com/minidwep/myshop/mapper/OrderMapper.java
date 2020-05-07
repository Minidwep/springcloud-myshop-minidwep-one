package com.minidwep.myshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.minidwep.myshop.entity.UserOrder;
import com.minidwep.myshop.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<UserOrder> {
}
