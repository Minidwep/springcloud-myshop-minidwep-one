package com.minidwep.myshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Goods {
    int id;
    String name;
    int stock;
    BigDecimal price;
    boolean couponFlag;
    Date deliveryTime;
}
