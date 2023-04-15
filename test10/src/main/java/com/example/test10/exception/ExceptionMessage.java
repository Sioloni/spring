package com.example.test10.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionMessage {
    ID_NOT_FOUND(HttpStatus.NOT_FOUND, "id is not found"),
    USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND, "username is not found"),
    FIO_NOT_FOUND(HttpStatus.NOT_FOUND, "fio is not found");


    private HttpStatus status;
    private String desc;
}
