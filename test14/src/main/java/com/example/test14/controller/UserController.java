package com.example.test14.controller;


import com.example.test14.model.dto.UserDto;
import com.example.test14.model.dto.create.UserCreateDto;
import com.example.test14.model.dto.update.UserUpdateDto;
import com.example.test14.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Log4j2
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService service;


    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping
    public List<UserDto> get() {
        log.info("Get request for get users");
        List<UserDto> userDtos = service.get();
        log.info("Get response for get users: {}", userDtos);
        return userDtos;
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        log.info("Get request for get by id: {}", id);
        UserDto userDto = service.get(id);
        log.info("Get response get user: {}", userDto);
        return userDto;
    }

    @PostMapping
    public UserDto create(@Valid @RequestBody UserCreateDto dto) {
        log.info("Get request for post user: {}", dto);
        UserDto userDto = service.create(dto);
        log.info("Get response for post user: {}", userDto);
        return userDto;
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @Valid @RequestBody UserDto dto) {
        log.info("Get request for put user: {}", dto);
        UserDto userDto = service.update(id, dto);
        log.info("Get response for put user: {}", userDto);
        return userDto;
    }

    @PatchMapping("/{id}")
    public UserDto updateUsername(@PathVariable Long id, @Valid @RequestBody UserUpdateDto dto) {
        log.info("Get request for patch username: {}", dto);
        UserDto userDto = service.updateUsername(id, dto);
        log.info("Get response for patch user: {}", userDto);
        return userDto;
    }

    @DeleteMapping("/{id}")
    public UserDto delete(@PathVariable Long id) {
        log.info("Get request for delete user by id: {}", id);
        UserDto userDto = service.delete(id);
        log.info("Get response for delete user: {}", userDto);
        return userDto;
    }

}
