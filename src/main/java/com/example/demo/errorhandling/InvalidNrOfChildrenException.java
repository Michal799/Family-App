package com.example.demo.errorhandling;

public class InvalidNrOfChildrenException extends RuntimeException{

    public InvalidNrOfChildrenException(String message) {
        super(message);
    }

}
