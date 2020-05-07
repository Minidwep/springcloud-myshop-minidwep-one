package com.minidwep.myshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.minidwep.myshop.domain.TbContent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TbContentMapper extends BaseMapper<TbContent> {
    List<TbContent> selectAll();
}