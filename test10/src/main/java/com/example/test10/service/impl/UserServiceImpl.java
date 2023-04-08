package com.example.test10.service.impl;

import com.example.test10.entity.User;
import com.example.test10.repository.UserRepository;
import com.example.test10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<User> get() {
        return repository.getUsers();
    }

    @Override
    public User get(Long id) {
        return repository.getUsers().stream()
                .filter(s -> s.getId().equals(id)).findAny()
                .orElseThrow(() -> new RuntimeException("user is not found"));
    }

    @Override
    public void create(User entity) {
        repository.getUsers().add(entity);
    }

    @Override
    public void update(Long id, User entity) {
        User entityUpdate = get(id);
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
    public void delete(Long id) {
        repository.getUsers().removeIf(s -> s.getId().equals(id));
    }
}
