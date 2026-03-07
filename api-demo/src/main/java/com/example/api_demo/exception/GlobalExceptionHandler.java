package com.example.api_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Global exception handler for the REST API.
 * Translates application and request errors into appropriate HTTP responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({InvalidLimitException.class, MethodArgumentTypeMismatchException.class})
    public ProblemDetail handleInvalidLimit(InvalidLimitException ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Invalid request parameter");
        problem.setDetail(ex.getMessage());
        return problem;
    }

    @ExceptionHandler(CsvReadException.class)
    public ProblemDetail handleCsvReadError(CsvReadException ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problem.setTitle("CSV processing error");
        problem.setDetail(ex.getMessage());
        return problem;
    }
}