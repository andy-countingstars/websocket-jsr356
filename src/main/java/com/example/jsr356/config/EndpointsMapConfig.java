package com.example.jsr356.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.websocket.Session;
import java.util.HashMap;

/**
 * This is Description
 *
 * @author xulongjie
 * @date 2019/10/25
 */
@Configuration
public class EndpointsMapConfig {

    @Bean
    public HashMap<String, Session> endpoints() {
        return new HashMap<>();
    }

}
