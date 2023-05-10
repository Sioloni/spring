package com.example.test14.controller;


import com.example.test14.entity.dto.UserDto;
import com.example.test14.entity.dto.UserUpdateDto;
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
        return service.get();
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        log.info("Get request for get by id: {}", id);
        return service.get(id);
    }

    @PostMapping
    public void create(@Valid @RequestBody UserDto dto) {
        log.info("Get request for post user: {}", dto);
        service.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody UserDto dto) {
        log.info("Get request for put user: {}", dto);
        service.updateAll(id, dto);
    }

    @PatchMapping("/{id}")
    public void updateUsername(@PathVariable Long id, @RequestParam UserUpdateDto dto) {
        log.info("Get request for patch username: {}", dto);
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Get request for delete user by id: {}", id);
        service.delete(id);
    }
}
