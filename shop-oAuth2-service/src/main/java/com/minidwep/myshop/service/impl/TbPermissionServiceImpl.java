package com.minidwep.myshop.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minidwep.myshop.mapper.TbPermissionMapper;
import com.minidwep.myshop.domain.TbPermission;
import com.minidwep.myshop.service.TbPermissionService;
@Service
public class TbPermissionServiceImpl extends ServiceImpl<TbPermissionMapper, TbPermission> implements TbPermissionService{

    @Resource
    TbPermissionMapper tbPermissionMapper;
    @Override
    public List<TbPermission> selectByUserId(long userId) {
        return tbPermissionMapper.selectByUserId(userId);
    }
}
