package com.example.demo.errorHandling;

public class InvalidNrOfAdultsException extends RuntimeException{

    public InvalidNrOfAdultsException(String message) {
        super(message);
    }

}
