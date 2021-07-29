package com.example.common.service;

/**
 * @author zhuliangxuan
 * @date 2021/7/29 10:07
 */
public interface RedisService {
    void set(Object key, Object value);

    Object get(Object key);
}
