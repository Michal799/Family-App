package com.example.demo.errorHandling;

public class InvalidNrOfChildrenException extends RuntimeException{

    public InvalidNrOfChildrenException(String message) {
        super(message);
    }

}
