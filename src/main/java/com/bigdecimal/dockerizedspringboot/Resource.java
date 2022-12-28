package com.bigdecimal.dockerizedspringboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {
    @GetMapping("/")
    public String index() {
        return "Dockerized Springboot App Running!";
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<? extends Object> createMessageForWhatsApp(@RequestBody WhatsAppMessage message) {
        ResponseEntity<? extends Object> response = new ResponseEntity<>(message, HttpStatus.CREATED);
        return response;
    }
}
