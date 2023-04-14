package com.example.test10.repository;

import com.example.test10.model.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepository {
    private ArrayList<UserDto> users = new ArrayList<>();


    {
        users.add(new UserDto(1L, "Angel", 19));
        users.add(new UserDto(2L, "Miki", 23));
        users.add(new UserDto(3L, "Julia", 29));
        users.add(new UserDto(4L, "Mike", 22));
        users.add(new UserDto(5L, "Alison", 25));

    }


    public ArrayList<UserDto> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserDto> users) {
        this.users = users;
    }
}
