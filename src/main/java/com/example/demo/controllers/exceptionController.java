package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.ApiResponse;

@RestControllerAdvice
public class exceptionController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse<Void> resourceNotFound(ResourceNotFoundException ex) {

        return new ApiResponse<>(false, ex.getMessage(), 422,null);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> validationError(MethodArgumentNotValidException ex){

        List<String> errorMessages = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());


        return new ApiResponse<>(false,errorMessages.toString(), HttpStatus.BAD_REQUEST.value(),null);
    }
    
}
