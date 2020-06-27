package com.potemkin.alfabattle.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.potemkin.alfabattle.task2.kafka.ConsumerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.MXBean;

@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public ConsumerService ConsumerService() {
        return new ConsumerService();
    }

}
