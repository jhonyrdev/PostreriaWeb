package com.postreria.server.Commons.exception;

public class unauthorizedException extends RuntimeException {
    public unauthorizedException(String message) {
        super(message);
    }
}