package com.example.test14.service.impl;

import com.example.test14.mapper.UserMapper;
import com.example.test14.model.User;
import com.example.test14.model.dto.UserDto;
import com.example.test14.repository.UserRepository;
import com.example.test14.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {
    private final UserService service;
    private final UserRepository repository;
    private final UserMapper mapper;


    @Autowired
    public UserServiceImplTest(UserService service, UserRepository repository, UserMapper mapper) {
        this.service = service;
        this.repository = repository;
        this.mapper = mapper;
    }


//    @Test
//    public void getUsers_whenGetAllUsers_thenListOfUsers() {
//        assertEquals(mapper.toEntity(service.get()), repository.findAll());
//    }
//
//    @Test
//    public void getUser_whenGetUserById_thenUser(){
//        Long id = 2L;
//        User user = new User(2L, "Miki", "miki@gmail.com", 19);
//
//        when(repository.findById(id).get()).thenReturn(user);

//        UserDto dto = service.get(id);
//        assertEquals(entity, dto);
//    }


//    @Test
//    public void deleteUserById_whenUserId_ThanUser() {
//        long id = 1L;
//        when(repository.findById(id).get()).thenReturn(mapper.toEntity(service.get(id)));
//    }












}
