package com.minidwep.myshop.controller;

import com.minidwep.myshop.domain.TbContent;
import com.minidwep.myshop.entity.Msg;
import com.minidwep.myshop.mapper.TbContentMapper;
import com.minidwep.myshop.service.TbContentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TbContentController {

    @Resource
    TbContentService tbContentService;

    @GetMapping("/")
    public Msg getList(){
        List<TbContent> tbContents = tbContentService.selectAll();
        return Msg.success().add("tbContents",tbContents);
    }

}
