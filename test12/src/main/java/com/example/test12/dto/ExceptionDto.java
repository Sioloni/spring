package com.example.test12.dto;


import com.example.test12.exception.ExceptionMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ExceptionDto {
    private ExceptionMessage massage;
    private String description;
}
