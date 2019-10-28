package com.example.jsr356.endpoints;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * This is Description
 *
 * @author xulongjie
 * @date 2019/10/22
 */
@Configuration
@ConditionalOnWebApplication
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }


    @Bean
    public MySpringConfigurator mySpringConfigurator() {
        return new MySpringConfigurator();
    }

}
