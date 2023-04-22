package com.example.test12.controller;



import com.example.test12.dto.UserDto;
import com.example.test12.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    
    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping
    public List<UserDto> get() {
        return service.get();
    }

    @GetMapping("/filter")
    public UserDto get(@RequestParam String username) {
        return  service.get(username);
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) throws Exception {
        return service.get(id);
    }

    @PostMapping
    public void create(@Valid @RequestBody UserDto entity) {
        service.create(entity);
    }

    @PutMapping("/{id}")
    public void updateAll(@PathVariable Long id,
                          @RequestBody UserDto entity) throws Exception {
        service.updateAll(id, entity);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody String fio) throws Exception {
        service.update(id, fio);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
