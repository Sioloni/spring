package com.example.test13.service;

import com.example.test13.model.dto.CreateUserDto;
import com.example.test13.model.dto.UserDto;

public interface UserService {
    UserDto createUser(CreateUserDto userDto);
}
