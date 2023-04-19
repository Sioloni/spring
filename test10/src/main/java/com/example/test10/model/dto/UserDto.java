package com.example.test10.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotBlank(message = "Invalid username")
    private String username;
    @Min(value = 7, message = "Invalid age")
    private Integer age;

}
