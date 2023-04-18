package com.rodrigo.study.exception;

public class RecordNotFoundException extends RuntimeException {
    
    public RecordNotFoundException(String message){
        super(message);
    }
}
