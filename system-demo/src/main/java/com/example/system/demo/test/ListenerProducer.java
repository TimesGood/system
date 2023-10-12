package com.example.system.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerProducer {
    @Autowired
    private ApplicationEventPublisher context;
    @EventListener
    public void register(){
        System.out.println("发送事件");
        context.publishEvent(new UserRegisteredEvent(this));
    }
}
