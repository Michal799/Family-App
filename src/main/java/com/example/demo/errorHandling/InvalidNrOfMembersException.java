package com.example.demo.errorHandling;

public class InvalidNrOfMembersException extends RuntimeException{

    public InvalidNrOfMembersException(String message) {
        super(message);
    }

}
