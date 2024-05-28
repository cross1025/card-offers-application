package com.capitial.verificationservice.controller;

import com.capitial.verificationservice.service.RabbitMQProducerService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("capital/verificationservice")
public class VerificationServiceController {

    @Autowired
    RabbitMQProducerService rabbitMQProducerService;

    @GetMapping("/message/{message}")
    public void testMessageSend(@PathVariable String message) {
        rabbitMQProducerService.sendMessage(message);
        System.out.println("Message Sent");

    }

}
