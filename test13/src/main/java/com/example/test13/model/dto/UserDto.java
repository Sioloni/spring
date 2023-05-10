package com.example.test13.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"username"})
public class UserDto {
    @Positive
    private Long id;
    @NotEmpty
    @ToString.Exclude
    private String username;
    @PastOrPresent
    private LocalDateTime date;
}
