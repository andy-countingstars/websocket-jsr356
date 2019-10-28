package com.example.jsr356.producer;

import com.example.jsr356.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * This is Description
 *
 * @author xulongjie
 * @date 2019/10/24
 */
@Component
public class JmsProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${demo.activemq.queue}")
    String queue;

    public void send(Customer customer) {
        jmsTemplate.convertAndSend(queue, customer);
    }

    public void send(String qrCodeId) {
        jmsTemplate.convertAndSend(queue, qrCodeId);
    }

}
