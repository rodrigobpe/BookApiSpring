package com.rodrigo.study.controller;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rodrigo.study.exception.RecordNotFoundException;
import com.rodrigo.study.model.Error;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlerNotFoundException(RecordNotFoundException e) {
        return new ResponseEntity<Object>(
            new Error( LocalDateTime.now(), HttpStatus.NOT_FOUND,e.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handlerNotFoundException(MethodArgumentTypeMismatchException e) {
        return new ResponseEntity<Object>(
                new Error(LocalDateTime.now(),HttpStatus.INTERNAL_SERVER_ERROR,e.getCause().getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<Object> handlerNotFoundException(MethodArgumentNotValidException e) {
        Map<String,String> errorMessage = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error ->{
            errorMessage.put(error.getField(),error.getDefaultMessage());
        });
        return new ResponseEntity<Object>(
            new Error(LocalDateTime.now(), HttpStatus.FORBIDDEN,errorMessage),
            HttpStatus.FORBIDDEN);

    }
}
