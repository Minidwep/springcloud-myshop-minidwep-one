package com.minidwep.myshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minidwep.myshop.domain.TbUser;
import com.minidwep.myshop.mapper.TbUserMapper;
import com.minidwep.myshop.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService{

    @Resource
    TbUserMapper tbUserMapper;

    @Override
    public TbUser getByUserName(String username) {
        QueryWrapper<TbUser> tbUserQueryWrapper = new QueryWrapper<>();
        tbUserQueryWrapper.eq("username", username);
        TbUser tbUser = tbUserMapper.selectOne(tbUserQueryWrapper);
        return tbUser;
    }
}
