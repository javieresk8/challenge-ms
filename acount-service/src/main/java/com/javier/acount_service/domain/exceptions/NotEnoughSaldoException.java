package com.javier.acount_service.domain.exceptions;

public class NotEnoughSaldoException extends RuntimeException {
    public NotEnoughSaldoException(String message) {
        super(message);
    }
}
