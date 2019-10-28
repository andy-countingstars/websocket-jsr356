package com.example.jsr356.service;

public interface RedisService {

    void setEx(String key, Object value, Long expire);

    Object getEx(String key);

}
