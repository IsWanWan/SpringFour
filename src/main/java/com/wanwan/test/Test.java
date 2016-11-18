package com.wanwan.test;

import redis.clients.jedis.Jedis;

/**
 * 测试
 *
 * @author wanwan
 * @create 2016-11-16 下午4:36
 */
public class Test {
    public static void main(String args[]){
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //设置 redis 字符串数据
        jedis.set("w3ckey", "hahaha");
        // 获取存储的数据并输出
        System.out.println("Stored string in redis:: "+ jedis.get("w3ckey"));
    }
}
