package com.example.jsr356.customer;

import com.example.jsr356.dto.QrMessageDTO;
import com.example.jsr356.model.MessageStorage;
import com.example.jsr356.service.RedisService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.annotation.JmsListener;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;
import java.util.HashMap;

/**
 * This is Description
 *
 * @author xulongjie
 * @date 2019/10/24
 */
@Configuration
public class JmsConsumer {

    @Autowired
    private MessageStorage customerStorage;

    @Autowired
    private RedisService redisService;

    @Autowired
    private HashMap<String, Session> endpoints;

    @Autowired
    private RedisTemplate redisTemplate;

    //get qrcode id & response to pointed client
    @JmsListener(destination = "${demo.activemq.queue}", containerFactory="jsaFactory")
    public void receive(String qrCodeId) throws IOException, EncodeException {
//        String sessionId = (String)redisService.getEx("session:" + qrCodeId);
//        String sessionId = (String)redisService.getEx("session1234");
//        String sessionId = (String) redisTemplate.boundValueOps("session1234").get();
//        String sessionId = "0";
//        Session session = endpoints.get(sessionId);
//        Object obj = redisService.getEx(qrCodeId);

//        session.getBasicRemote().sendObject(new QrMessageDTO());

        String sessionId = (String) redisService.getEx("session" + qrCodeId);
        sessionId = "session" + sessionId;
        Session session = endpoints.get(sessionId);
        session.getBasicRemote().sendObject(new QrMessageDTO());
    }


//    @JmsListener(destination = "${demo.activemq.queue}", containerFactory="jsaFactory")
//    public void receive(Customer customer){
//        System.out.println("Recieved Message: " + customer);
//        customerStorage.add(customer);
//    }

}
