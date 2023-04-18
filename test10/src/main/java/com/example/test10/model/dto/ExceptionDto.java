package com.example.test10.model.dto;


import com.example.test10.exception.ExceptionMessage;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class ExceptionDto {
    private ExceptionMessage massage;
    private String description;
}
