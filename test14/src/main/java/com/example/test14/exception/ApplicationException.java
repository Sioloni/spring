package com.example.test14.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApplicationException extends Error{
    private ExceptionMessage exceptionMessage;
}
