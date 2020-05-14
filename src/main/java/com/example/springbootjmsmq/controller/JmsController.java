package com.example.springbootjmsmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.JmsException;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class JmsController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("status")
    public boolean status() {
        JmsListenerEndpointRegistry registry = applicationContext.getBean(JmsListenerEndpointRegistry.class);
        return registry.isRunning();
    }

    @GetMapping("put")
    public String put() {
        try {
            jmsTemplate.convertAndSend("DEV.QUEUE.1", "Hello World!");
            return "OK";
        } catch (JmsException ex) {
            ex.printStackTrace();
            return "FAIL";
        }
    }

    /***
     * Remove @JmsListener to make this method work
     * */
    @GetMapping("get")
    public String get() {
        try {
            return Objects.requireNonNull(jmsTemplate.receiveAndConvert("DEV.QUEUE.1")).toString();
        } catch (JmsException ex) {
            ex.printStackTrace();
            return "FAIL";
        }
    }
}
