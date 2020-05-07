package com.minidwep.myshop.controller;

import com.minidwep.myshop.entity.Msg;
import com.minidwep.myshop.entity.User;
import com.minidwep.myshop.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class UserController {
    @Resource
    UserService userService;

    @PutMapping("/user/money/{id}/{money}")
    public Msg disMoney(@PathVariable("id") int id, @PathVariable("money") BigDecimal money){
        User user = userService.getById(id);
        user.setMoney(user.getMoney().subtract(money));
        boolean flag = userService.updateById(user);
        return flag?Msg.success():Msg.fail();
    }

    @GetMapping("/test")
    public Msg test(){
        return Msg.success();
    }
}
