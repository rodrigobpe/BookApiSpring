package com.rodrigo.study.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private Object errorMessage;
}
