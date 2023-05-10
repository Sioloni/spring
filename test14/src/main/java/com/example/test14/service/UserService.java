package com.example.test14.service;

import com.example.test14.entity.dto.UserDto;
import com.example.test14.entity.dto.UserUpdateDto;

import java.util.List;

public interface UserService {

    List<UserDto> get();

    UserDto get(Long id);

    void create(UserDto dto);

    void updateAll(Long id, UserDto dto);

    void update(Long id, UserUpdateDto dto);

    void delete(Long id);
}
