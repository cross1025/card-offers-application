package com.capital.messagenotificationservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumerService {

    @RabbitListener(queues = "email-send")
    public void receiveMessage(@Payload String message) {
        System.out.println("Received message: " + message);
    }
}
