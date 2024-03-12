package com.kafka.project.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String,String> kafkaTemplate;
    public void sendMessage(String message){
        log.info(format("Sending message to sree topic :: %s", message));
        kafkaTemplate.send("sree",message);
    }
}
