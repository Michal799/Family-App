package com.example.demo.errorHandling;

public class FamilyNotFoundException extends RuntimeException {

    public FamilyNotFoundException(String message) {
        super(message);
    }

}