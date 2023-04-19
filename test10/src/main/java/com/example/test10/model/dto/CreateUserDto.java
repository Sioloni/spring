package com.example.test10.model.dto;


import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    private Long id;

    @NotBlank(message = "The username must be filled in")
    private String username;

    @Min(value = 1, message = "The age must be greater than one")
    private Integer age;

    @FutureOrPresent(message = "The date must be in the past or in the present")
    private Date date;
}
