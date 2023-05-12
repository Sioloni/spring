package com.example.test14.model.dto.create;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    @NotBlank
    @Size(min = 4, max = 30)
    private String username;

    @Email
    private String email;

    @Min(value = 10)
    @Max(value = 50)
    private Integer age;
}
