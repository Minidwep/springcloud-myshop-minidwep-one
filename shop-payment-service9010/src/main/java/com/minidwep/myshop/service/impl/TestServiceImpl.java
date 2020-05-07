package com.minidwep.myshop.service.impl;

import com.minidwep.myshop.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public void Test() {
        System.out.println("hahah");
    }
}
