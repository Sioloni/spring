package com.example.test12.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExceptionMessage {
    ID_NOT_FOUND(HttpStatus.NOT_FOUND, "id is not found"),
    USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND, "username is not found"),
    FIO_NOT_FOUND(HttpStatus.NOT_FOUND, "fio is not found");


    private HttpStatus status;
    private String desc;

}
