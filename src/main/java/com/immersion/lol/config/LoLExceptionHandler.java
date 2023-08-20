package com.immersion.lol.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class LoLExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> exceptionHandler(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();

        return ResponseEntity
                .internalServerError()
                .body(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> exceptionHandler(MissingServletRequestParameterException e){
        log.error(e.getMessage());

        return ResponseEntity
                .badRequest()
                .body(e.getMessage());
    }
}
