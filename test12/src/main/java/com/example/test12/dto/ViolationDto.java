package com.example.test12.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ViolationDto {
    private String fieldName;
    private String message;
}
