package com.example.test14.controller;


import com.example.test14.entity.User;
import com.example.test14.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class UserControllerTest {
    private UserRepository repository;
    private MockMvc mockMvc;


    @Autowired
    public UserControllerTest(UserRepository repository, MockMvc mockMvc) {
        this.repository = repository;
        this.mockMvc = mockMvc;
    }


    @Test
    public void getUsers_whenGetAllUsers_thenListUsers() throws Exception {
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user"));
        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andExpect(jsonPath("$.size()", CoreMatchers.is(repository.findAll().size())));
        response.andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void createUser_createNewUser_thenNothing() throws Exception {
        User entity = new User(5L, "Alison", "alison@gmail.com", 19);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user")
                .content(new ObjectMapper().writeValueAsString(entity))
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getUser_whenGetId_thenUser() throws Exception {
        Long id = 4L;
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON).
                content(new ObjectMapper().writeValueAsString(repository.findById(id).get())));

        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andExpect(jsonPath("$.size()", CoreMatchers.is(repository.findAll().size())));
        response.andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void deleteUserById_whenUserId_thenNothing() throws Exception {
        long id = 1L;

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/user/{id}", id));

        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getUserByName_whenUserExists_thenUser() throws Exception {
        Long id = 2L;

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/user/{id}?username=Angel", id)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andDo(MockMvcResultHandlers.print());
    }











}
