package com.example.test14.service.impl;

import com.example.test14.entity.dto.UserDto;
import com.example.test14.entity.User;
import com.example.test14.entity.dto.UserUpdateDto;
import com.example.test14.exception.ApplicationException;
import com.example.test14.exception.ExceptionMessage;
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
        return mapper.toDto(repository.findAll());
    }

    @Override
    public UserDto get(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionMessage.ID_NOT_FOUND)));
    }

    @Override
    public void create(UserDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public void updateAll(Long id, UserDto dto) {
        User user = mapper.toEntity(get(id));
        repository.save(mapper.update(user, dto));
    }

    @Override
    public void update(Long id, UserUpdateDto dto) {
        User user = mapper.toEntity(get(id));
        if (dto.getUsername() != null && !dto.getUsername().isEmpty()) {
            user.setUsername(dto.getUsername());
        } else {
            throw new ApplicationException(ExceptionMessage.USERNAME_NOT_FOUND);
        }
        repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
