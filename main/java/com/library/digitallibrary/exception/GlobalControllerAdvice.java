package com.library.digitallibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidExcep(MethodArgumentNotValidException e){

        Map<String,String> errorMap=new HashMap<>();
        for(FieldError error:e.getBindingResult().getFieldErrors()){
            errorMap.put(error.getField(),error.getDefaultMessage());

        }
        return  new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?>handleNoSuchElementException(NoSuchElementException e){

        return new ResponseEntity<>("The requested data is not available "+e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

