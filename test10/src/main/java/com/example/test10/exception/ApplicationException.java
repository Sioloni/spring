package com.example.test10.exception;


import lombok.Data;

@Data
public class ApplicationException extends RuntimeException{

    private ExceptionMessage message;


    public ApplicationException(ExceptionMessage message) {
        this.message = message;
    }
}
