package com.javaee.support.utils;

import com.alibaba.fastjson.JSON;
import com.javaee.common.pojo.Account;
import com.javaee.support.constants.SupportConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void set(String key,String value){
        redisTemplate.opsForValue().set(key,value, SupportConstants.EXPIRE, TimeUnit.SECONDS);
    }

    public<T> void setObject(String key,T t){
        String json = JSON.toJSONString(t);
        set(key,json);
    }

    public String get(String key){
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            return null;
        }
    }

    public<T> T getObject(String key,Class<T> clazz){
        String s = get(key);
        return JSON.parseObject(s,clazz);
    }

    public static String generateLoginKey(String id){
        return SupportConstants.LOGIN + id;
    }


    public Boolean del(String key) {
        return redisTemplate.opsForValue().getOperations().delete(key);
    }

    public void setExpire(String key, int time) {
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }
}
