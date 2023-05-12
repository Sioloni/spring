package com.example.test14.service;

import com.example.test14.model.dto.UserDto;
import com.example.test14.model.dto.create.UserCreateDto;
import com.example.test14.model.dto.update.UserUpdateDto;

import java.util.List;

public interface UserService {
    List<UserDto> get();

    UserDto get(Long id);

    UserDto create(UserCreateDto dto);

    UserDto update(Long id, UserDto dto);

    UserDto updateUsername(Long id, UserUpdateDto dto);

    UserDto delete(Long id);
}
