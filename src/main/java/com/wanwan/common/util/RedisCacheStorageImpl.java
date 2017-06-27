package com.wanwan.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

import java.util.HashMap;
import java.util.Map;

/**
 * redis 缓存存储器实现
 *
 * @author wanwan
 * @create 2016-11-18 上午11:30
 */
@Component
public class RedisCacheStorageImpl<V>{
    /**
     * 日志记录
     */
    private static final Logger LOG = LoggerFactory.getLogger(RedisClient.class);

    /**
     * 默认过时时间
     */
    private static final int EXPRIE_TIME =3600*24;

    /**
     * redis 客户端
     */

    private static final RedisClient redisClient = new RedisClient();


    /**
     * 获取JedisUtil实例
     * @return
     */


    /**
     * 在redis数据库中插入 key  和value
     *
     * @param key
     * @param value
     * @return
     */

    public boolean set(String key, V value) {
        // 先不做设置默认过时时间
        return set(key, value);
    }

    /**
     * 在redis数据库中插入 key  和value 并且设置过期时间
     *
     * @param key
     * @param value
     * @param exp   过期时间 s
     * @return
     */

    public boolean set(String key, V value, int exp) {
        Jedis jedis =null;
        //将key 和value  转换成 json 对象
        String jKey =JSON.toJSONString(key);
        String jValue =JSON.toJSONString(value);
        //操作是否成功
        boolean isSucess =true;
        if(StringUtils.isNotEmpty(jKey)){
            LOG.info("key is empty");
            return false;
        }
        try {
            //获取客户端对象
            jedis =redisClient.getResource();
            //执行插入
            jedis.setex(jKey, exp, jValue);
        } catch (JedisException e) {
            LOG.info("client can't connect server");
            isSucess =false;
            if(null !=jedis){
                //释放jedis对象
                redisClient.brokenResource(jedis);
            }
            return false;
        }finally{
            if(isSucess){
                //返还连接池
                redisClient.returnResource(jedis);
            }
            return true;
        }
    }

    /**
     * 根据key 去redis 中获取value
     *
     * @param key
     * @return
     */

    public V get(String key) {
        Jedis jedis =null;
        //将key 和value  转换成 json 对象
        String jKey =JSON.toJSONString(key);
        V jValue =null;
        //key 不能为空
        if(StringUtils.isEmpty(jKey)){
            LOG.info("key is empty");
            return null;
        }
        try {
            //获取客户端对象
            jedis =redisClient.getResource();
            //执行查询
            String value =  jedis.get(jKey);
            //判断值是否非空
            if(StringUtils.isEmpty(value)){
                return null;
            }else{
                jValue= (V) JSON.parseObject(value);
            }
            //返还连接池
            redisClient.returnResource(jedis);
        } catch (JedisException e) {
            LOG.info("client can't connect server");
            if(null !=jedis){
                //释放jedis 对象
                redisClient.brokenResource(jedis);
            }
        }
        return jValue;
    }

    /**
     * 删除redis库中的数据
     *
     * @param key
     * @return
     */

    public boolean remove(String key) {
        Jedis jedis =null;
        //将key 和value  转换成 json 对象
        String jKey =JSON.toJSONString(key);
        //操作是否成功
        boolean isSucess =true;
        if(StringUtils.isEmpty(jKey)){
            LOG.info("key is empty");
            return false;
        }
        try {
            jedis =redisClient.getResource();
            //执行删除
            jedis.del(jKey);
        } catch (JedisException e) {
            LOG.info("client can't connect server");
            isSucess =false;
            if(null !=jedis){
                //释放jedis 对象
                redisClient.brokenResource(jedis);
            }
            return false;
        }finally{
            if (isSucess) {
                //返还连接池
                redisClient.returnResource(jedis);
            }
            return true;
        }
    }

    /**
     * 设置哈希类型数据到redis 数据库
     *
     * @param cacheKey 可以看做一张表
     * @param key      表字段
     * @param value
     * @return
     */

    public boolean hset(String cacheKey, String key, V value) {
        Jedis jedis =null;
        //将key 和value  转换成 json 对象
        String jKey =JSON.toJSONString(key);
        String jCacheKey =JSON.toJSONString(cacheKey);
        String jValue =JSON.toJSONString(value);
        //操作是否成功
        boolean isSucess =true;
        if(StringUtils.isEmpty(jCacheKey)){
            LOG.info("cacheKey is empty");
            return false;
        }
        try {
            jedis =redisClient.getResource();
            //执行插入哈希
            jedis.hset(jCacheKey, jKey, jValue);
        } catch (JedisException e) {
            LOG.info("client can't connect server");
            isSucess =false;
            if(null !=jedis){
                //释放jedis 对象
                redisClient.brokenResource(jedis);
            }
            return false;
        }finally{
            if (isSucess) {
                //返还连接池
                redisClient.returnResource(jedis);
            }
            return true;
        }
    }

    /**
     * 获取哈希表数据类型的值
     *
     * @param cacheKey
     * @param key
     * @return
     */

    public String hget(String cacheKey, String key) {
        Jedis jedis =null;
        //将key 和value  转换成 json 对象
        String jKey =JSON.toJSONString(key);
        String jCacheKey =JSON.toJSONString(cacheKey);
        V jValue =null;
        String value="";
        if(StringUtils.isEmpty(jCacheKey)){
            LOG.info("cacheKey is empty");
            return null;
        }
        try {
            //获取客户端对象
            jedis =redisClient.getResource();
            //执行查询
             value =  jedis.hget(jCacheKey, jKey);
            //判断值是否非空
            if(StringUtils.isEmpty(value)){
                return null;
            }else{
                jValue= (V)JSON.parseObject(value);
            }
            //返还连接池
            redisClient.returnResource(jedis);
        } catch (JedisException e) {
            LOG.info("client can't connect server");
            if(null !=jedis){
                //释放jedis 对象
                redisClient.brokenResource(jedis);
            }
        }
        return value;
    }

    /**
     * 获取哈希类型的数据
     *
     * @param cacheKey
     * @return
     */

    public Map<String, V> hget(String cacheKey) {
        String jCacheKey =JSON.toJSONString(cacheKey);
        //非空校验
        if(StringUtils.isEmpty(jCacheKey)){
            LOG.info("cacheKey is empty!");
            return null;
        }
        Jedis jedis =null;
        Map<String,V> result =null;
        try {
            jedis =redisClient.getResource();
            //获取列表集合
            Map<String,String> map = jedis.hgetAll(jCacheKey);

            if(null !=map){
                for(Map.Entry<String, String> entry : map.entrySet()){
                    if(result ==null){
                        result =new HashMap<String,V>();
                    }
                    result.put(String.valueOf(JSON.parseObject(entry.getKey())), (V)JSON.parseObject(entry.getValue()));
                }
            }
        } catch (JedisException e) {
            LOG.info("client can't connect server");
            if(null !=jedis){
                //释放jedis 对象
                redisClient.brokenResource(jedis);
            }
        }
        return result;
    }

}

