package com.example.test14.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    @NotBlank
    @Size(min = 4, max = 30)
    private String username;

    @Email
    private String email;

    @Min(value = 10)
    @Max(value = 50)
    private Integer age;
}
