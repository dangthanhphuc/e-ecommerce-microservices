package org.microservices.consumer_service.exceptions;

import org.microservices.consumer_service.responses.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler{

    /**
     * Validation error handler.
     * This method will handle input validation errors for api and return a HTTP 400 Bad Request response with the validation errors.
     *
     * @param ex
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseObject<String>> handleIdNotFoundException(IdNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
          ResponseObject.error(ex.getMessage())
        );
    }

}
