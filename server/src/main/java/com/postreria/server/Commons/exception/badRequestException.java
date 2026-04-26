package com.postreria.server.Commons.exception;

public class badRequestException extends RuntimeException {
    public badRequestException(String message) {
        super(message);
    }
}
