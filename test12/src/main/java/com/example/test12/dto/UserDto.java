package com.example.test12.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    @NotBlank(message = "Invalid username")
    private String username;
    @Min(value = 7, message = "Invalid age")
    private Integer age;

}
