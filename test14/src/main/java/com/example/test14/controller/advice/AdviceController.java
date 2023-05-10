package com.example.test14.controller.advice;


import com.example.test14.entity.dto.ApplicationExceptionDto;
import com.example.test14.entity.dto.ValidationDto;
import com.example.test14.exception.ApplicationException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AdviceController {


    @ExceptionHandler
    public ApplicationExceptionDto exceptionHandler(ApplicationException ex) {
        return new ApplicationExceptionDto(ex.getExceptionMessage().getStatus().toString(), ex.getExceptionMessage().getDesc());
    }

    @ExceptionHandler
    public List<ValidationDto> validationDtoHandler(ConstraintViolationException ex) {
        List<ValidationDto> validationDtos =
                ex
                        .getConstraintViolations().stream()
                        .map(s -> new ValidationDto(s.getPropertyPath().toString(), s.getMessage()))
                        .collect(Collectors.toList());
        return validationDtos;
    }

    @ExceptionHandler
    public List<ValidationDto> validationParamHandler(MethodArgumentNotValidException ex) {
        List<ValidationDto> validationDtos = ex
                .getBindingResult().getFieldErrors().stream()
                .map(s -> new ValidationDto(s.getField(), s.getDefaultMessage()))
                .collect(Collectors.toList());
        return validationDtos;
    }
}
