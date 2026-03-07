package com.example.api_demo.exception;

public class CsvReadException extends RuntimeException {

    public CsvReadException(String message) {
        super(message);
    }

    public CsvReadException(String message, Throwable cause) {
        super(message, cause);
    }
}