package com.example.jsr356.endpoints;

import com.example.jsr356.dto.QrMessageDTO;
import com.example.jsr356.producer.JmsProducer;
import com.example.jsr356.service.RedisService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;

/**
 * This is Description
 *
 * @author xulongjie
 * @date 2019/10/24
 */
@Component
@ServerEndpoint(value = "/serverEndpoint", encoders = TextMessageEncoder.class, decoders = TextMessageDecoder.class)
public class QrServerEndpoint {

    /**
     * store session in a map
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        endpoints.put("session" + session.getId(), session);
    }

    @Autowired
    private static HashMap<String, Session> endpoints;

    @Autowired
    public void setEndpoints(HashMap endpoints) {
        QrServerEndpoint.endpoints = endpoints;
    }

    @Autowired
    private static JmsProducer jmsProducer;

    @Autowired
    public void setJmsProducer(JmsProducer jmsProducer) {
        QrServerEndpoint.jmsProducer = jmsProducer;
    }

    @Autowired
    private static RedisService redisService;

    @Autowired
    public void setChatService(RedisService redisService) {
        QrServerEndpoint.redisService = redisService;
    }

    /**
     * store key: qrcodeId in Redis, value: session id
     * @param session
     * @param messageDTO
     */
    @OnMessage
    public void onMessage(Session session, QrMessageDTO messageDTO) {
//        endpoints.put(session.getId(), session);
        String qrCodeId = messageDTO.getQrCodeId();
        System.out.println("received a message");
        System.out.println(qrCodeId);
        redisService.setEx("session" + qrCodeId, session.getId(), 100000L);
//        jmsProducer.send("1234");
    }

//    @OnError
//    public void onError() {
//
//    }

//    @OnClose
//    public void onClose() {
//
//    }

}
