package org.example.test;


import org.springframework.beans.factory.annotation.Value;

//@Component
public class User {
    @Value("${user.username}")
    private String username;
    @Value("${user.age}")
    private Integer age;


    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public User() {}


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
