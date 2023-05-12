package com.example.test14.service.impl;

import com.example.test14.model.dto.UserDto;
import com.example.test14.model.User;
import com.example.test14.model.dto.create.UserCreateDto;
import com.example.test14.model.dto.update.UserUpdateDto;
import com.example.test14.model.exception.ApplicationException;
import com.example.test14.model.exception.ExceptionMessage;
import com.example.test14.mapper.UserMapper;
import com.example.test14.repository.UserRepository;
import com.example.test14.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;


    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<UserDto> get() {
        List<User> users = repository.findAll();
        List<UserDto> dto = mapper.toDto(users);
        return dto;
    }

    @Override
    public UserDto get(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionMessage.ID_NOT_FOUND));
        UserDto dto = mapper.toDto(user);
        return dto;
    }

    @Override
    public UserDto create(UserCreateDto dto) {
        User user = mapper.toEntity(dto);
        User userSave = repository.save(user);
        UserDto userDto = mapper.toDto(userSave);
        return userDto;
    }

    @Override
    public UserDto update(Long id, UserDto dto) {
        UserDto userDto = get(id);
        User user = mapper.toEntity(userDto);
        User userUpdate = mapper.update(user, dto);
        User userSave = repository.save(userUpdate);
        UserDto dtoSave = mapper.toDto(userSave);
        return dtoSave;
    }

    @Override
    public UserDto updateUsername(Long id, UserUpdateDto dto) {
        UserDto userDto = get(id);
        User user = mapper.toEntity(userDto);
        user.setUsername(dto.getUsername());
        User userSave = repository.save(user);
        UserDto dtoSave = mapper.toDto(userSave);
        return dtoSave;
    }

    @Override
    public UserDto delete(Long id) {
        UserDto userDto = get(id);
        repository.deleteById(id);
        return userDto;
    }
}
