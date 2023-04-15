package com.example.test10.exception;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class ApplicationException extends RuntimeException{

    private ExceptionMessage message;

}
