package com.example.test10.repository;

import com.example.test10.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    {
        users.add(new User(1L, "Miki", 19));
        users.add(new User(2L, "Alison", 27));
        users.add(new User(3L, "Julia", 29));

    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
