package com.minidwep.myshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.minidwep.myshop.domain.TbUser;

public interface TbUserService extends IService<TbUser>{
    TbUser getByUserName(String username);

}
