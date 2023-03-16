package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
//public class RestExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(PetNotFoundException.class)
//    
//    public ResponseEntity<Object> handleProductNotFound(PetNotFoundException ex, WebRequest request) {
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", LocalDateTime.now());
//        body.put("message", ex.getMessage());
//
//        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//    }
//}

@ControllerAdvice
public class RestExceptionHandler {
   
    @ExceptionHandler(value = { PetNotFoundException.class })
    public ResponseEntity<String> handleProductNotFoundException(PetNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    
    @ExceptionHandler(value = { PetValidationException.class })
    public ResponseEntity<String> handleProductValidationException(PetValidationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    
    
}

