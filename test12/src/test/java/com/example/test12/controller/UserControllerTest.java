package com.example.test12.controller;


import com.example.test12.dto.UserDto;
import com.example.test12.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class UserControllerTest {
    @Mock
    private UserRepository repository;
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getUsers_whenGetAllUsers_thenListOfUsers() throws Exception {
        List<UserDto> users = new ArrayList<>();
        users.add(new UserDto(1L, "Angel", 19));
        users.add(new UserDto(2L, "Miki", 23));
        users.add(new UserDto(3L, "Julia", 29));
        users.add(new UserDto(4L, "Mike", 22));
        users.add(new UserDto(5L, "Alison", 25));
        repository.createAll(users);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/user"));

        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andExpect(jsonPath("$.size()", CoreMatchers.is(users.size())));
        response.andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getUserByName_whenUserExists_thenUser() throws Exception {
        String username = "Angel";

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/user?username=" + username));

        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andExpect(jsonPath("$.length()").value(username.length()));
        response.andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void deleteUserById_whenUserId_thenNothing() throws Exception {
        long id = 5L;

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.delete("/user/{id}", id));

        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void createUser_createNewUser_thenNothing() throws Exception {
        UserDto userDto = new UserDto(5L, "Angel", 29);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .content(new ObjectMapper().writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andDo(MockMvcResultHandlers.print());
    }
}
