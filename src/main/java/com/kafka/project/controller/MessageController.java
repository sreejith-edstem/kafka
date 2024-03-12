package com.kafka.project.controller;

import com.kafka.project.payload.Student;
import com.kafka.project.service.KafkaJsonProducer;
import com.kafka.project.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaProducerService kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    //    @GetMapping("/publish")
//    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
//        kafkaProducerTopicService.sendMessage(message);
//        return ResponseEntity.ok("Message returned successfully");
//    }
    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student message) {
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully as JSON");
    }
}
