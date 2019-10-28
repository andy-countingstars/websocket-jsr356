package com.example.jsr356.config;

import com.example.jsr356.model.MessageStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is Description
 *
 * @author xulongjie
 * @date 2019/10/24
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public MessageStorage customerStorage() {
        return new MessageStorage();
    }

}
