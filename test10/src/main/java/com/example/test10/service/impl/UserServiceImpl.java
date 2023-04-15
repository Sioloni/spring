package com.example.test10.service.impl;

import com.example.test10.exception.ApplicationException;
import com.example.test10.exception.ExceptionMessage;
import com.example.test10.model.dto.UserDto;
import com.example.test10.repository.UserRepository;
import com.example.test10.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public UserDto get(String username) {
        return repository.getUsers().stream()
                .filter(s -> s.getUsername().equals(username))
                .findFirst().orElseThrow(() -> new ApplicationException(ExceptionMessage.USERNAME_NOT_FOUND));
    }

    @Override
    public List<UserDto> get() {
        return repository.getUsers();
    }

    @Override
    public UserDto get(Long id) {
        return repository.getUsers().stream()
                .filter(s -> s.getId().equals(id))
                .findAny().orElseThrow(() -> new ApplicationException(ExceptionMessage.ID_NOT_FOUND));
    }

    @Override
    public void create(UserDto entity) {
        repository.getUsers().add(entity);
    }

    @Override
    public void updateAll(Long id, UserDto entity) {
        UserDto entityUpdate = get(id);
        delete(id);
        if (entityUpdate.getUsername() != null && !entityUpdate.getUsername().isEmpty()) {
            entityUpdate.setUsername(entity.getUsername());
        }
        if (entityUpdate.getAge() != null && !entityUpdate.getAge().toString().isEmpty()) {
            entityUpdate.setAge(entity.getAge());
        }
        repository.getUsers().add(entityUpdate);
    }

    @Override
    public void update(Long id, String fio) {
        UserDto entityUpdate = get(id);
        delete(id);
        if (fio == null) {
            throw new ApplicationException(ExceptionMessage.FIO_NOT_FOUND);
        } else {
            entityUpdate.setUsername(fio);
        }
        repository.getUsers().add(entityUpdate);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new ApplicationException(ExceptionMessage.ID_NOT_FOUND);
        } else {
            repository.getUsers().removeIf(s -> s.getId().equals(id));
        }

    }
}
