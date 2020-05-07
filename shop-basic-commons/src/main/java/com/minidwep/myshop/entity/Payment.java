package com.minidwep.myshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    Long id;
    Long orderId;
    Date payTime;

}
