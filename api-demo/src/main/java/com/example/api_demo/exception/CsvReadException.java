package com.example.api_demo.exception;

/**
 * Runtime exception thrown when an error occurs while reading or processing the CSV data source.
 */
public class CsvReadException extends RuntimeException {

    public CsvReadException(String message) {
        super(message);
    }

    public CsvReadException(String message, Throwable cause) {
        super(message, cause);
    }
}