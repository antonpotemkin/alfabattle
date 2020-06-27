package com.potemkin.alfabattle.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    private final Logger logger = LoggerFactory.getLogger(AppController.class);
    private static final String TOPIC = "topic";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    private void post(@RequestBody String string) {
        kafkaTemplate.send(TOPIC, string);
    }

    @GetMapping
    public String hello() {
        return "Hello";
    }

}
