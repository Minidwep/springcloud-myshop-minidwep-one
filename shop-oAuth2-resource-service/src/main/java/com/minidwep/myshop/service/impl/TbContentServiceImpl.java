package com.minidwep.myshop.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minidwep.myshop.domain.TbContent;
import com.minidwep.myshop.mapper.TbContentMapper;
import com.minidwep.myshop.service.TbContentService;
@Service
public class TbContentServiceImpl extends ServiceImpl<TbContentMapper, TbContent> implements TbContentService{

    @Resource
    TbContentMapper tbContentMapper;
    @Override
    public List<TbContent> selectAll() {
        return tbContentMapper.selectAll();
    }
}
