package com.example.system.security.exception;

import org.springframework.security.core.AuthenticationException;

public class CaptchaException extends AuthenticationException {
    public CaptchaException(String message) {
        super(message);
    }
}
