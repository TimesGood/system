package com.example.system.demo.test;

import org.springframework.context.ApplicationEvent;

public class UserRegisteredEvent extends ApplicationEvent {
    /**
     * @param source 事件源，就是谁发的
     */
    public UserRegisteredEvent(Object source) {
        super(source);
    }
}
