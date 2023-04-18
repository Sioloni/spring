package com.example.test10.controller.advice;





import com.example.test10.exception.ApplicationException;
import com.example.test10.model.dto.ExceptionDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {


    @ExceptionHandler
    public ExceptionDto handler(ApplicationException ex){
        return new ExceptionDto(ex.getExceptionMessage(), ex.getExceptionMessage().getDesc());
    }








}
