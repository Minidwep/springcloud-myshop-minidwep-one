package com.minidwep.myshop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.minidwep.myshop.provider.EchoServiceTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboTestController {

    @Reference(version = "1.0.0")
    private EchoServiceTest echoServiceTest;

    @GetMapping("/echo")
    public String echo(){

        return echoServiceTest.echo("123");
    }
}
