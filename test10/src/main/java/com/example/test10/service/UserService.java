package com.example.test10.service;


import com.example.test10.model.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> get(String username);

    List<UserDto> get();

    UserDto get(Long id);

    void create(UserDto entity);

    void update(Long id, String fio);

    void updateAll(Long id, UserDto entity);

    void delete(Long id);
}
