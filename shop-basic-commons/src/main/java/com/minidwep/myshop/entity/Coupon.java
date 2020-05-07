package com.minidwep.myshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
    @TableId(value = "id",type = IdType.INPUT)
    Long id;
    int userId;
    String detail;
    BigDecimal minCount;
    BigDecimal disCount;
}
