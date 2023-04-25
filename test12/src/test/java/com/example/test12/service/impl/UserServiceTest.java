package com.example.test12.service.impl;


import com.example.test12.dto.UserDto;
import com.example.test12.exception.ApplicationException;
import com.example.test12.exception.ExceptionMessage;
import com.example.test12.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
    @Autowired
    private UserServiceImpl service;
    @MockBean
    private UserRepository repository;

    private List<UserDto> users = new ArrayList<>();

    {
        users.add(new UserDto(1L, "Angel", 19));
        users.add(new UserDto(2L, "Miki", 23));
        users.add(new UserDto(3L, "Julia", 29));
        users.add(new UserDto(4L, "Mike", 22));
        users.add(new UserDto(5L, "Alison", 25));
    }


    @Test
    public void getUsers_whenGetAllUsers_thenListOfUsers() {
        when(repository.getUsers()).thenReturn(users);
        assertEquals(service.get(), users);
    }

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
