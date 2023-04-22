package com.example.test10.controller.advice;


import com.example.test10.exception.ApplicationException;
import com.example.test10.exception.ValidationErrorResponse;
import com.example.test10.exception.Violation;
import com.example.test10.model.dto.ExceptionDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AdviceController {


    @ExceptionHandler
    public ExceptionDto handler(ApplicationException ex) {
        return new ExceptionDto(ex.getExceptionMessage(), ex.getExceptionMessage().getDesc());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse onConstraintValidationException(
            ConstraintViolationException e
    ) {
        final List<Violation> violations = e.getConstraintViolations().stream()
                .map(
                        violation -> new Violation(
                                violation.getPropertyPath().toString(),
                                violation.getMessage()
                        )
                )
                .collect(Collectors.toList());
        return new ValidationErrorResponse(violations);
    }

}
