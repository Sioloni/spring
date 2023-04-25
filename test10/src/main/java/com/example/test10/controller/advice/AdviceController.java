package com.example.test10.controller.advice;


import com.example.test10.exception.ApplicationException;
import com.example.test10.model.dto.ViolationDto;
import com.example.test10.model.dto.ExceptionDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class AdviceController {


    @ExceptionHandler
    public ExceptionDto handlerExceptionUser(ApplicationException ex) {
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
