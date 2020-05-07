package com.minidwep.myshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minidwep.myshop.entity.User;
import com.minidwep.myshop.mapper.UserMapper;
import com.minidwep.myshop.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
