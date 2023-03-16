package com.example.demo.exception;

public class PetValidationException extends RuntimeException {
    public PetValidationException(String message) {
        super(message);
    }
}
