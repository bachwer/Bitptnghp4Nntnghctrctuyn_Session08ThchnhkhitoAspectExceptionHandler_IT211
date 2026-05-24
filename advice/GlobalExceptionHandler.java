package org.example.ex4.advice;

import jakarta.validation.ConstraintViolationException;

import org.example.ex4.dto.ErrorResponse;
import org.example.ex4.exception.AccessDeniedException;
import org.example.ex4.exception.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404 NOT FOUND
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse>
    handleResourceNotFound(ResourceNotFoundException ex) {

        ErrorResponse errorResponse =
                new ErrorResponse(
                        404,
                        "Not Found",
                        ex.getMessage()
                );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    // 403 FORBIDDEN
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse>
    handleAccessDenied(AccessDeniedException ex) {

        ErrorResponse errorResponse =
                new ErrorResponse(
                        403,
                        "Forbidden",
                        ex.getMessage()
                );

        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(errorResponse);
    }

    // 400 VALIDATION ERROR
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse>
    handleValidationException(
            ConstraintViolationException ex
    ) {

        ErrorResponse errorResponse =
                new ErrorResponse(
                        400,
                        "Bad Request",
                        ex.getMessage()
                );

        return ResponseEntity
                .badRequest()
                .body(errorResponse);
    }

    // 500 INTERNAL SERVER ERROR
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse>
    handleGeneralException(Exception ex) {

        ErrorResponse errorResponse =
                new ErrorResponse(
                        500,
                        "Internal Server Error",
                        "Something went wrong."
                );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }
}