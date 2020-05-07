package com.minidwep.myshop.service;

import com.minidwep.myshop.domain.TbPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPermissionService extends IService<TbPermission> {
    List<TbPermission> selectByUserId(long userId);

}
