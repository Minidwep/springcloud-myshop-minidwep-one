package com.minidwep.myshop.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minidwep.myshop.mapper.TbContentCategoryMapper;
import com.minidwep.myshop.domain.TbContentCategory;
import com.minidwep.myshop.service.TbContentCategoryService;
@Service
public class TbContentCategoryServiceImpl extends ServiceImpl<TbContentCategoryMapper, TbContentCategory> implements TbContentCategoryService{

}
