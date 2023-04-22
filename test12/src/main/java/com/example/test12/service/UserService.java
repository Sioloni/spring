package com.example.test12.service;




import com.example.test12.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto get(String username);

    List<UserDto> get();

    UserDto get(Long id) throws Exception;

    void create(UserDto entity);

    void update(Long id, String fio) throws Exception;

    void updateAll(Long id, UserDto entity) throws Exception;

    void delete(Long id);
}
