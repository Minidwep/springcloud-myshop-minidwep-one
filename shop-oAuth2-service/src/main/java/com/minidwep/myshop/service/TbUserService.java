package com.minidwep.myshop.service;

import com.minidwep.myshop.domain.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TbUserService extends IService<TbUser>{
    TbUser getByUserName(String username);

}
