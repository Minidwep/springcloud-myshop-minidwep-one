package com.minidwep.myshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.minidwep.myshop.domain.TbPermission;

import java.util.List;

public interface TbPermissionService extends IService<TbPermission> {
    List<TbPermission> selectByUserId(long userId);

}
