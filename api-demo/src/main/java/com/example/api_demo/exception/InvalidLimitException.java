package com.example.api_demo.exception;

/**
 * Runtime exception thrown when the provided limit parameter is invalid.
 */
public class InvalidLimitException extends RuntimeException {

    public InvalidLimitException(String messsage){
        super(messsage);
    }

}
