package com.minidwep.myshop.service;

import com.minidwep.myshop.entity.Msg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.math.BigDecimal;

@FeignClient(value = "${myshop.user-url}")
public interface UserService {

    @PutMapping("/user/money/{id}/{money}")
    Msg disMoney(@PathVariable("id") int id, @PathVariable("money") BigDecimal money);

}
