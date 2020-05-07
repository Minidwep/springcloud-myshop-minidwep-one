package com.minidwep.myshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrder {
    @TableId(value = "id",type = IdType.INPUT)
    Long id;
    int goodsId;
    int goodsNum;
    int userId;
    Long couponId;
    BigDecimal payMoney;
    Date buyTime;
    boolean status;
    boolean overTime;

}
