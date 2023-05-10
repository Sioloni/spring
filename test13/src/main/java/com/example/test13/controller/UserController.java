package com.example.test13.controller;


import com.example.test13.model.dto.CreateUserDto;
import com.example.test13.model.dto.UserDto;
import com.example.test13.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Log4j2
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;


    @PostMapping
    public UserDto createUser(@RequestBody CreateUserDto dto){

        UserDto userDto = service.createUser(dto);

        return userDto;
    }





}
