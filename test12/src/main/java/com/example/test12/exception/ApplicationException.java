package com.example.test12.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException{
    private ExceptionMessage exceptionMessage;

}