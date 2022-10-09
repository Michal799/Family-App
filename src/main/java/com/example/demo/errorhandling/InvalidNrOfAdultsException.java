package com.example.demo.errorhandling;

public class InvalidNrOfAdultsException extends RuntimeException{

    public InvalidNrOfAdultsException(String message) {
        super(message);
    }

}
