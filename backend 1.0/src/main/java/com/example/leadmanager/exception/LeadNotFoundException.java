package com.example.leadmanager.exception;

public class LeadNotFoundException extends RuntimeException {

    public LeadNotFoundException(String message) {
        super(message);
    }
}
