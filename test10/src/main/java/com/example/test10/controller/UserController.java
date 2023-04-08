package com.example.test10.controller;


import com.example.test10.entity.User;
import com.example.test10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService service;


    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping
    public List<User> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public void create(@RequestBody User entity) {
        service.create(entity);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody User entity) {
        service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
