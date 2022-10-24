package com.kafka.errorhandling.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic}")
    private String topic;

    @GetMapping("/produce/{message}")
    public void produceMessage(@PathVariable("message") final String message) {
        kafkaTemplate.send(topic, message);
    }
}
