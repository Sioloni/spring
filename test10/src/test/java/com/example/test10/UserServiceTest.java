package com.example.test10;


import com.example.test10.model.dto.UserDto;
import com.example.test10.repository.UserRepository;
import com.example.test10.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository repository;
    @InjectMocks
    private UserServiceImpl service;
    private UserDto user;


    @Test
    @DisplayName("JUnit test for get all User method")
    public void getAllUsersDtoObject(){
        List<UserDto> users = service.get();
        System.out.println(users);
    }

    @Test
    @DisplayName("JUnit test for get User method")
    public void getByIdUserDtoObject(){
        service.get(1L);
    }

    @Test
    @DisplayName("JUnit test for save User method")
    public void saveUserDtoObject(){
        service.create(user);
    }

    @Test
    @DisplayName("JUnit test for delete User method")
    public void deleteUserDtoObject(){
        service.delete(1L);
    }

    @Test
    @DisplayName("JUnit test for update User method")
    public void updateUserDtoObject(){
        service.update(1L, "Miki");
    }



}
