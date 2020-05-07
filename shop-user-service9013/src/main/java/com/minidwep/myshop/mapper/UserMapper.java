package com.minidwep.myshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.minidwep.myshop.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
