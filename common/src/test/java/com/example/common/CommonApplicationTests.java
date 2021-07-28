package com.example.common;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class CommonApplicationTests {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("str2","value2");
        Object str2 = redisTemplate.opsForValue().get("str2");
        System.out.println(str2);
    }

}
