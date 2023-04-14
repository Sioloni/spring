package com.example.test10.service.impl;

import com.example.test10.exception.Processing;
import com.example.test10.model.dto.UserDto;
import com.example.test10.repository.UserRepository;
import com.example.test10.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public List<UserDto> get(String username) {
        return repository.getUsers().stream()
                .filter(s -> s.getUsername().equals(username)).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> get() {
        return repository.getUsers();
    }

    @Override
    public UserDto get(Long id) throws Exception {
        Optional<UserDto> optionalUserDto = repository.getUsers().stream()
                .filter(s -> s.getId().equals(id)).findAny();
        if (optionalUserDto.isPresent()) {
            return optionalUserDto.get();
        } else {
            throw Processing.SEARCH_MODEL_BY_ID.getException();
        }
    }

    @Override
    public void create(UserDto entity) {
        repository.getUsers().add(entity);
    }

    @Override
    public void updateAll(Long id, UserDto entity) throws Exception {
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
    public void update(Long id, String fio) throws Exception {
        UserDto entityUpdate = get(id);
        delete(id);
        if (entityUpdate.getUsername() != null && !entityUpdate.getUsername().isEmpty()) {
            entityUpdate.setUsername(fio);
        }
        repository.getUsers().add(entityUpdate);
    }

    @Override
    public void delete(Long id) {
        repository.getUsers().removeIf(s -> s.getId().equals(id));
    }
}
