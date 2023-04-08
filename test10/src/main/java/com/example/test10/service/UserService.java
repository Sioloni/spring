package com.example.test10.service;



import com.example.test10.entity.User;

import java.util.List;

public interface UserService {

    List<User> get();

    User get(Long id);

    void create(User entity);

    void update(Long id, User entity);

    void delete(Long id);
}
