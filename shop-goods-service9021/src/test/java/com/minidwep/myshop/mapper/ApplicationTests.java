package com.minidwep.myshop.mapper;
import com.alibaba.fastjson.JSONObject;
import com.minidwep.myshop.entity.Goods;
import com.minidwep.myshop.entity.Msg;
import com.minidwep.myshop.entity.UserOrder;

import com.minidwep.myshop.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import util.SnowFlakeId;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

@SpringBootTest
class ApplicationTests {
    @Resource
    GoodsService goodsService;

    @Resource
    RedissonClient redissonClient;
    @Autowired
    JedisPool jedisPool;
    @Test
    void contextLoads() {

        String goodsRedis = "myshop-seckill-id-1";
//        RBucket<Object> bucket = redissonClient.getBucket(goodsRedis);
//        bucket.set(47);
//        Goods goods = new Goods();
//        goods.setStock(100);
//        goods.setCouponFlag(true);
//        goods.setId(1);
//        goods.setName("redis_goods");
//        goods.setPrice(new BigDecimal(10));
//        goods.setDeliveryTime(new Date());
//        HashMap hashMap = JSONObject.parseObject(JSONObject.toJSONString(goods), HashMap.class);

//        redisMap.putAll(hashMap);


    }



}
