package com.kirillsheremet.cryptowatch.exception_handling;

public class NoSuchCoinException extends RuntimeException {
    public NoSuchCoinException(String message) {
        super(message);
    }
}
