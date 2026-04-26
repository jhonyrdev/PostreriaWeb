package com.postreria.server.Commons.exception;

public class resourceNotFoundException extends RuntimeException {
    public resourceNotFoundException(String message) {
        super(message);
    }
}
