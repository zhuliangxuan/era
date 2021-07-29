package com.example.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author zhuliangxuan
 * @date 2021/7/29 10:08
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public void set(Object key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public Object get(Object key) {
        return redisTemplate.opsForValue().get(key);
    }
}
