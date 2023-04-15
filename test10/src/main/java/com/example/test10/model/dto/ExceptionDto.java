package com.example.test10.model.dto;


import com.example.test10.model.exception.ExceptionMessage;
import lombok.*;

@Data
@AllArgsConstructor
public class ExceptionDto {
    private ExceptionMessage massage;
    private String description;

}
