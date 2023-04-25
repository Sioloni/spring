package com.example.test12.controller.advice;


import com.example.test12.dto.ExceptionDto;
import com.example.test12.exception.ApplicationException;
import com.example.test12.dto.ViolationDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AdviceController {


    @ExceptionHandler
    public ExceptionDto handler(ApplicationException ex) {
        return new ExceptionDto(ex.getExceptionMessage(), ex.getExceptionMessage().getDesc());
    }

    @ExceptionHandler
    public List<ViolationDto> handlerExceptionValidation(ConstraintViolationException ex) {
        List<ViolationDto> violations = ex.getConstraintViolations().stream()
                .map(s -> new ViolationDto(s.getPropertyPath().toString(), s.getMessage()))
                .collect(Collectors.toList());
        return violations;
    }


}
