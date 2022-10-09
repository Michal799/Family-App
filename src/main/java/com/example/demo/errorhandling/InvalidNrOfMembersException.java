package com.example.demo.errorhandling;

public class InvalidNrOfMembersException extends RuntimeException{

    public InvalidNrOfMembersException(String message) {
        super(message);
    }

}
