package com.example.system.demo.test;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerConsumer {
    @EventListener
    public void listener(UserRegisteredEvent event){
        System.out.println("监听到事件："+event);
    }
}
