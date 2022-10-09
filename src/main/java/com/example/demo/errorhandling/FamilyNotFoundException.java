package com.example.demo.errorhandling;

public class FamilyNotFoundException extends RuntimeException {

    public FamilyNotFoundException(String message) {
        super(message);
    }

}