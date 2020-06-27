package com.potemkin.alfabattle.task2.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

public class ConsumerService {
    private final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    private final TaskExecutor exec = new SimpleAsyncTaskExecutor();

    @KafkaListener(topics = "RAW_PAYMENTS", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
