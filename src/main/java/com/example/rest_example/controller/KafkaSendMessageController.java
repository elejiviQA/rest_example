package com.example.rest_example.controller;

import com.example.rest_example.entity.Cat;
import com.example.rest_example.kafka.KafkaProducer;
import com.example.rest_example.repository.CatRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaSendMessageController {

    private final CatRepo catRepo;

    private final KafkaProducer kafkaProducer;

    public KafkaSendMessageController(CatRepo catRepo, KafkaProducer kafkaProducer) {
        this.catRepo = catRepo;
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("kafka/send")
    public String send(@RequestParam int id) {
        Cat cat = catRepo.findById(id).get();
        kafkaProducer.sendMessage(cat.toString());
        return "Successfully sent message";
    }
}
