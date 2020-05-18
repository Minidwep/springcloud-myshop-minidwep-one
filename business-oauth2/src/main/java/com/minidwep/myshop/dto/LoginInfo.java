package com.minidwep.myshop.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author minid
 * 用户登录信息
 */
@Data
public class LoginInfo implements Serializable {
    private String name;
    private String avatar;
}
