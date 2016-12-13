package com.wanwan.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 封装redis 客户端
 *
 * @author wanwan
 * @create 2016-11-18 上午11:24
 */
public class RedisClient {
    /**
     * 日志记录
     */
    private static final Logger LOG = LoggerFactory.getLogger(RedisClient.class);
    /**
     * redis 连接池
     */
    private static JedisPool pool = null;

    public static void setPool(JedisPool pool) {
        RedisClient.pool = pool;
    }

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        //控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
        //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        config.setMaxTotal(500);
        //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(5);
        //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(1000 * 100);
        //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        config.setTestOnBorrow(true);

        //redis如果设置了密码：
            /*jedisPool = new JedisPool(config, JRedisPoolConfig.REDIS_IP,
                    JRedisPoolConfig.REDIS_PORT,
                    10000,JRedisPoolConfig.REDIS_PASSWORD);    */

        //redis未设置了密码：
        pool = new JedisPool(config, "127.0.0.1",6379,10000,"123456");
    }

     public RedisClient(){

    }
    /**
     * 获取jedis
     * @return
     */
    public Jedis getResource(){
        Jedis jedis =null;
        try {
            jedis =pool.getResource();
        } catch (Exception e) {
            LOG.info("can't  get  the redis resource");
        }
        return jedis;
    }
    /**
     * 关闭连接
     * @param jedis
     */
    public void disconnect(Jedis jedis){
        jedis.disconnect();
    }
    /**
     * 将jedis 返还连接池
     * @param jedis
     */
    public void returnResource(Jedis jedis){
        if(null != jedis){
            try {
                pool.returnResource(jedis);
            } catch (Exception e) {
                LOG.info("can't return jedis to jedisPool");
            }
        }
    }
    /**
     * 无法返还jedispool，释放jedis客户端对象，
     * @param jedis
     */
    public void brokenResource(Jedis jedis){
        if (jedis!=null) {
            try {
                pool.returnBrokenResource(jedis);
            } catch (Exception e) {
                LOG.info("can't release jedis Object");
            }
        }
    }
}
