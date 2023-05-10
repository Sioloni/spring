package com.example.test12.service.impl;


import com.example.test12.dto.UserDto;
import com.example.test12.exception.ApplicationException;
import com.example.test12.exception.ExceptionMessage;
import com.example.test12.repository.UserRepository;
import com.example.test12.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    private UserService service;
    private UserRepository repository;


    @Autowired
    public UserServiceTest(UserService service, UserRepository repository) {
        this.service = service;
        this.repository = repository;
    }
//
//
//    @Test
//    public void getUsers_whenGetAllUsers_thenListOfUsers() {
//        when(repository.getUsers()).thenReturn(users);
//        assertEquals(service.get(), users);
//    }

    @Test
    public void getUserByName_whenUserExists_thenUser() {
        String name = "Angel";
        UserDto expectedUser = UserDto.builder()
                .id(1L)
                .username("Angel")
                .age(19)
                .build();

        when(repository.getUserByName(eq(name)))
                .thenReturn(Optional.of(expectedUser));

        UserDto actualUser = service.get(name);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void getUserByName_whenUserNotExists_thenException() {
        String name = "test";

        ExceptionMessage expectedExceptionMessage = ExceptionMessage.USERNAME_NOT_FOUND;

        when(repository.getUserByName(name))
                .thenReturn(Optional.empty());

        ApplicationException actualApplicationException = assertThrows(ApplicationException.class, () -> service.get(name));
        assertEquals(expectedExceptionMessage, actualApplicationException.getExceptionMessage());
    }

    @Test
    public void deleteUserById_whenUserId_ThanTrue() {
        long id = 1L;
        when(repository.deleteById(id))
                .thenReturn(true);
    }

}
