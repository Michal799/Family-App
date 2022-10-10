package com.example.demo.errorHandling;

public class InvalidAgeException extends RuntimeException{

    public InvalidAgeException(String message) {
        super(message);
    }

}
