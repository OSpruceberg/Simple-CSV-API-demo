package com.example.api_demo.exception;

public class InvalidLimitException extends RuntimeException {

    public InvalidLimitException(String messsage){
        super(messsage);
    }

}
