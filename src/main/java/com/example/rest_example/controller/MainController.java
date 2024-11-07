package com.example.rest_example.controller;

import com.example.rest_example.entity.Cat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/api/main")//сюда перенаправляются HTTP-методы GET
    public String mainListener() {
        return "Hello World";
    }

    @GetMapping("/api/cat")
    public String giveCat() {
        Cat cat = new Cat("Mickey", 5, 4);
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            System.out.println("Json Cat Exception");
        }

        return jsonData;
    }

    @PostMapping("/api/special")
    public String giveSpecialCat(@RequestParam String name, @RequestParam int age, @RequestParam int weight) {
        Cat cat = new Cat(name, age, weight);
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            System.out.println("Json Cat Exception");
        }

        return jsonData;
    }
}