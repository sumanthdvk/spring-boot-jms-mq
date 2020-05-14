package com.example.springbootjmsmq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MQListener {
    @JmsListener(destination = "DEV.QUEUE.1")
    public void receiveMessage(String message) {
        System.out.println(message);
    }
}
