package com.wanwan.common.test;

import com.wanwan.common.util.RedisClient;
import com.wanwan.common.util.SerializeUtil;
import com.wanwan.domain.Admin;
import redis.clients.jedis.Jedis;

/**
 * 测试
 *
 * @author wanwan
 * @create 2016-11-16 下午4:36
 */
public class Test {
    private static final RedisClient redisClient = new RedisClient();
    public static void main(String args[]){
////        Jedis jedis = new Jedis("localhost");
//
//        Jedis jedis = redisClient.getResource();
//
////        System.out.println("Connection to server sucessfully");
////        //设置 redis 字符串数据
////        jedis.set("hhhh", "zhaoxiuling");
////        // 获取存储的数据并输出
////        System.out.println("Stored string in redis:: "+ jedis.get("hhhh"));
//        Admin admin = new Admin();
//        admin.setUsername("HAHA");
//        admin.setAddress("上海");
////        Admin a  = new Admin();
////        a.setUsername("AA");
////        a.setAddress("ddd");
//
//
//        RedisClient.getResource().set("admin1".getBytes(), SerializeUtil.serialize(admin));
//        byte[] bg1 =  RedisClient.getResource().get("admin1".getBytes());
//        Admin adminOne = (Admin) SerializeUtil.unserialize(bg1);
//        System.out.println(adminOne.getUsername());


    }
}
