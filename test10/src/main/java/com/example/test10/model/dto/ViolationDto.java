package com.example.test10.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ViolationDto {
    private String fieldName;
    private String message;
}
