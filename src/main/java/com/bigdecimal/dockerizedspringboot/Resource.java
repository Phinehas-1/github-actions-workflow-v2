package com.bigdecimal.dockerizedspringboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {
    private WhatsAppMessageService messageService;

    public Resource(WhatsAppMessageService messageService) {
        this.messageService = messageService;
    }
    
    @GetMapping("/")
    public String index() {
        return "Dockerized Springboot App Running!";
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<? extends Object> createMessageForWhatsApp(@RequestBody WhatsAppMessage message) {
        ResponseEntity<? extends Object> response = new ResponseEntity<>(message, HttpStatus.CREATED);
        try {
            if (messageService.sendTwilioMessage(message)) {
                return response;
            }
            response = new ResponseEntity<>("Message wasn't sent.", HttpStatus.BAD_GATEWAY);
        } catch (Exception e) {
            response = new ResponseEntity<>(e, HttpStatus.BAD_GATEWAY);
        }
        return response;
    }
}
