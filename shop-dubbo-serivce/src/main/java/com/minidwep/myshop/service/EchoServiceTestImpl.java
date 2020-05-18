package com.minidwep.myshop.service;

import com.minidwep.myshop.provider.EchoServiceTest;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class EchoServiceTestImpl implements EchoServiceTest {
    @Override
    public String echo(String str) {
        return "hello dubbo"+str;
    }
}
