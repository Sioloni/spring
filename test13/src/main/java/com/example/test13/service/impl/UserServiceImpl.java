package com.example.test13.service.impl;

import com.example.test13.model.dto.CreateUserDto;
import com.example.test13.model.dto.UserDto;
import com.example.test13.service.UserService;

import java.time.LocalDateTime;

public class UserServiceImpl implements UserService {


    @Override
    public UserDto createUser(CreateUserDto userDto) {
        UserDto userDto1 = UserDto.builder()
                .id(1L)
                .username("Miki")
                .date(LocalDateTime.now())
                .build();

        return userDto1;
    }
}
