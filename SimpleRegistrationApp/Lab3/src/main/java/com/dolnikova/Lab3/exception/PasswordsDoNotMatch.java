package com.dolnikova.Lab3.exception;

public class PasswordsDoNotMatch extends RuntimeException {
    public PasswordsDoNotMatch(String message) {
        super(message);
    }
}
