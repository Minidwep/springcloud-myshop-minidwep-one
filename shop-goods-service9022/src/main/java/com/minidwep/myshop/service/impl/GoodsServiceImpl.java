package com.minidwep.myshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minidwep.myshop.entity.Goods;
import com.minidwep.myshop.entity.Msg;
import com.minidwep.myshop.entity.UserOrder;
import com.minidwep.myshop.mapper.GoodsMapper;
import com.minidwep.myshop.mapper.OrderMapper;
import com.minidwep.myshop.service.GoodsService;
import com.minidwep.myshop.util.RedisUtil;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;
import util.SnowFlakeId;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private RedissonClient redissonClient;
    @Resource
    GoodsMapper goodsMapper;

    @Resource
    RedisUtil redisUtil;
//    private Lock lock = new ReentrantLock();

    @Resource
    OrderMapper orderMapper;

    @Override
//    使用synchronized锁
    public  synchronized  boolean minusGoods(int goodsId) {
        Goods goods = goodsMapper.selectById(goodsId);
        int goodsNum = goods.getStock();
        if(goodsNum -1 <0)
            return false;
        goods.setStock(goodsNum-1);
        goodsMapper.updateById(goods);
        System.out.println("库存还有"+(goodsNum-1));
        long snowflakeId = SnowFlakeId.snowflakeId(0, 1L);
        UserOrder userOrder = new UserOrder();
        userOrder.setId(snowflakeId);
        userOrder.setGoodsId(goodsId);
        orderMapper.insert(userOrder);
        return true;
    }


//    @Override
////    使用 lock 锁
//    @Transactional
//    public   boolean minusGoods(int goodsId) {
//        try {
//            lock.lock();
//            Goods goods = goodsMapper.selectById(goodsId);
//            int goodsNum = goods.getStock();
//            if(goodsNum -1 <0)
//                return false;
//            goods.setStock(goodsNum-1);
//            goodsMapper.updateById(goods);
//            System.out.println("库存还有"+(goodsNum-1));
//            long snowflakeId = SnowFlakeId.snowflakeId(0, 1L);
//            UserOrder userOrder = new UserOrder();
//            userOrder.setId(snowflakeId);
//            userOrder.setGoodsId(goodsId);
//            orderMapper.insert(userOrder);
//            return true;
//        } catch (Exception e){
//            e.printStackTrace();
//            return false;
//        } finally {
//            lock.unlock();
//        }
//
//    }

    //    读取Redis
    @Override
    public boolean minusSecKilGoods(int goodsId) {
        String key = "myshop-seckill-key-id"+goodsId;
        String goodsRedis = "myshop-seckill-id-1";
        RLock lock = redissonClient.getLock(key);
        System.out.println("得到锁");
        try {
            //加锁 操作很类似Java的ReentrantLock机制
            lock.lock();
            RMap<Object, Object> redisMap = redissonClient.getMap("redis");
            Object stockObj = redisMap.get("stock");
            int stock = Integer.parseInt(stockObj.toString());
            if(stock <= 1 ){
                return  false;
            }
            redisMap.put("stock", stock-1);
            long snowflakeId = SnowFlakeId.snowflakeId(0, 1L);
            UserOrder userOrder = new UserOrder();
            userOrder.setId(snowflakeId);
            userOrder.setGoodsId(goodsId);
            orderMapper.insert(userOrder);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            lock.unlock();
        }
    }
////    读取数据库
//    @Override
//    public boolean minusSecKilGoods(int goodsId) {
//        String key = "myshop-seckill-key-id"+goodsId;
//        RLock lock = redissonClient.getLock(key);
//        System.out.println("得到锁");
//        try {
//            //加锁 操作很类似Java的ReentrantLock机制
//            lock.lock();
////            System.out.println("线程延迟30S");
////            Thread.sleep(30000);
////            System.out.println("延时结束");
////            System.out.println("线程延迟20S");
////            Thread.sleep(20000);
////            System.out.println("延时结束");
//            Goods goods = goodsMapper.selectById(goodsId);
//            int goodsNum = goods.getStock();
//            if(goodsNum -1 <0)
//                return false;
//            goods.setStock(goodsNum-1);
//            goodsMapper.updateById(goods);
//            System.out.println("库存还有"+(goodsNum-1));
//            long snowflakeId = SnowFlakeId.snowflakeId(0, 1L);
//            UserOrder userOrder = new UserOrder();
//            userOrder.setId(snowflakeId);
//            userOrder.setGoodsId(goodsId);
//            orderMapper.insert(userOrder);
//            return true;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return false;
//        } finally {
//            //解锁
////            手动删除KV
////            redisUtil.del(0, key);
//            lock.unlock();
//        }
//////        return true
////
////        String s1 = redisUtil.get("123", 0);
//////        System.out.println(s);
////        System.out.println(s1);
//
//    }
}
