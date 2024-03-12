package com.kafka.project.service;

import com.kafka.project.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {

//    @KafkaListener(topics = "sree", groupId = "myGroup")
    public void consumeMsg(String msg) {
        log.info(format("Consuming the message from topic_sample Topic:: %s", msg));
    }
    @KafkaListener(topics = "sree", groupId = "myGroup")
    public void consumeJsonMsg(Student student) {
        log.info(format("Consuming the message from sree Topic:: %s", student.toString()));
    }
}
