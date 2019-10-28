package com.example.jsr356.service.impl;

import com.example.jsr356.service.RedisService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

/**
 * This is Description
 *
 * @author xulongjie
 * @date 2019/10/24
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void setEx(String key, Object value, Long expire) {
        Gson gson = new Gson();
        String s = gson.toJson(value);
        System.out.println(s);
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer serializer = redisTemplate.getStringSerializer();
                redisConnection.setEx(key.getBytes(), expire, serializer.serialize(value));
                return null;
            }
        });
    }

    @Override
    public Object getEx(String key) {
        Object result = redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer serializer = redisTemplate.getStringSerializer();
                byte[] bytes = redisConnection.get(key.getBytes());
                return serializer.deserialize(bytes);
            }
        });
        return result;
    }


}
