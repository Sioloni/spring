package com.example.test10.model.dto;


import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ExceptionDto {
    private HttpStatus status;
    private String description;

}
