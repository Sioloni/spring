package com.example.test12.repository;

import com.example.test12.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private List<UserDto> users = new ArrayList<>();

    {
        users.add(new UserDto(1L, "Angel", 19));
        users.add(new UserDto(2L, "Miki", 23));
        users.add(new UserDto(3L, "Julia", 29));
        users.add(new UserDto(4L, "Mike", 22));
        users.add(new UserDto(5L, "Alison", 25));
    }


    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserDto> users) {
        this.users = users;
    }

    public Optional<UserDto> getUserByName(String username) {
        return users.stream().filter(s -> s.getUsername().equals(username)).findAny();
    }

    public boolean deleteById(Long id) {
        return users.removeIf(s -> s.getId().equals(id));
    }

    public void createAll(List<UserDto> users) {
        this.users.addAll(users);
    }
}
