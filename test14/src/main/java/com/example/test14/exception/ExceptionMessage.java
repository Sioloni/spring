package com.example.test14.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {
    ID_NOT_FOUND(HttpStatus.NOT_FOUND, "id is not found"),
    USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND, "username is not found");

    private HttpStatus status;
    private String desc;
}
