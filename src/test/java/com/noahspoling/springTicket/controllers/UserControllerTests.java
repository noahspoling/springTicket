package com.noahspoling.springTicket.controllers;


import com.noahspoling.springTicket.entity.User;
import com.noahspoling.springTicket.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {

    @Mock
    private UserService service;
    private UserController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new UserController(service);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetUsers() throws Exception {
        User user1 = new User();
        User user2 = new User();
        List<User> users = Arrays.asList(user1, user2);

        when(service.getUsers()).thenReturn(users);

        mockMvc.perform(get("/api/v1/user/"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetUser() throws Exception {
        User user = new User();

        when(service.getUser(anyLong())).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/v1/user/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testAddUser() throws Exception {
        User user = new User();

        mockMvc.perform(post("/api/v1/user/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateUser() throws Exception {
        User user = new User();
        HashMap<String, Object> params = new HashMap<>();

        mockMvc.perform(put("/api/v1/user/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/api/v1/user/1"))
                .andExpect(status().isOk());
    }
}

