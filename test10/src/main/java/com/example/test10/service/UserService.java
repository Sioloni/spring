package com.example.test10.service;


import com.example.test10.model.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> get(String username);

    List<UserDto> get();

    UserDto get(Long id) throws Exception;

    void create(UserDto entity);

    void update(Long id, String fio) throws Exception;

    void updateAll(Long id, UserDto entity) throws Exception;

    void delete(Long id);
}
