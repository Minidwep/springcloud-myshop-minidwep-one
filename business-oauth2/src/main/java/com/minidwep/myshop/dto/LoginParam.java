package com.minidwep.myshop.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author minid
 * 登陆对象
 */
@Data
public class LoginParam implements Serializable {
    private String username;
    private String password;

}
