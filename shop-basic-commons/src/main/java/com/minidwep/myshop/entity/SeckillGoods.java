package com.minidwep.myshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeckillGoods {
    int id;
    String name;
    int stock;
    BigDecimal price;
    boolean couponFlag;
    Date advanceTime;
    Date finalTime;
}
