package com.minidwep.myshop.service;

import com.minidwep.myshop.domain.TbContent;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TbContentService extends IService<TbContent>{


    List<TbContent> selectAll();
}
