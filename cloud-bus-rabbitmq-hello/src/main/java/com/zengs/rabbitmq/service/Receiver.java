package com.zengs.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hellospringboot")
public class Receiver {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver: "+hello);
    }
}
