package com.minidwep.myshop.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    int id;
    String username;
    String password;
    String name;
    String phone;
    String address;
    BigDecimal money;
}
