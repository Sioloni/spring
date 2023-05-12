package com.example.test14.mapper;

import com.example.test14.model.User;
import com.example.test14.model.dto.UserDto;
import com.example.test14.model.dto.create.UserCreateDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    public User toEntity(UserDto dto) {
        return new User
                (
                dto.getId(),
                dto.getUsername(),
                dto.getEmail(),
                dto.getAge()
        );
    }

    public User toEntity(UserCreateDto dto) {
        return new User
                (
                        null,
                        dto.getUsername(),
                        dto.getEmail(),
                        dto.getAge()
                );
    }


    public UserDto toDto(User entity) {
        return new UserDto
                (
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getAge()
        );
    }

    public List<User> toEntity(List<UserDto> dto) {
        return dto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<UserDto> toDto(List<User> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }

    public User update(User entity, UserDto dto) {
        User entityUpdate = toEntity(dto);
        if (entityUpdate.getUsername() != null && !entityUpdate.getUsername().isEmpty()) {
            entity.setUsername(entityUpdate.getUsername());
        }
        if (entityUpdate.getEmail() != null && !entityUpdate.getEmail().isEmpty()) {
            entity.setEmail(entityUpdate.getEmail());
        }
        if (entityUpdate.getAge() != null) {
            entity.setAge(entityUpdate.getAge());
        }
        return entity;
    }

}
