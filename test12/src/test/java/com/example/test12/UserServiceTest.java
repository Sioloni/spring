package com.example.test12;


import com.example.test12.dto.UserDto;
import com.example.test12.repository.UserRepository;
import com.example.test12.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository repository;
    @InjectMocks
    private UserServiceImpl service;
    @Mock
    private UserDto userDto;


    @Test
    @DisplayName("JUnit test for get User method")
    public void getById_Should_Return_UserDto(){
        given(service.get(1L)).willReturn(new UserDto(1L, "Angel", 19));
    }

    @Test
    @DisplayName("JUnit test for save User method")
    public void saveUserDto_Correct_Result(){
        service.create(userDto);
    }




}
