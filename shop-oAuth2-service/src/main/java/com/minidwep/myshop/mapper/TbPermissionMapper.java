package com.minidwep.myshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.minidwep.myshop.domain.TbPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TbPermissionMapper extends BaseMapper<TbPermission> {
    List<TbPermission> selectByUserId(long userId);
}