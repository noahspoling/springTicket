package com.noahspoling.springTicket.services;

import com.noahspoling.springTicket.dao.UserDAO;
import com.noahspoling.springTicket.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    private UserDAO dao;
    private UserService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new UserService(dao);
    }

    @Test
    void testGetUser() {
        User expectedUser = new User();
        when(dao.get(1L)).thenReturn(Optional.of(expectedUser));

        Optional<User> result = service.getUser(1L);
        assertTrue(result.isPresent());
        assertEquals(expectedUser, result.get());
    }

    @Test
    void testGetUserNotFound() {
        when(dao.get(1L)).thenReturn(Optional.empty());

        Optional<User> result = service.getUser(1L);
        assertNull(result);
    }

    @Test
    void testGetUsers() {
        User user1 = new User();
        User user2 = new User();
        List<User> expectedUsers = Arrays.asList(user1, user2);

        when(dao.getAll()).thenReturn(expectedUsers);

        List<User> result = service.getUsers();
        assertEquals(expectedUsers, result);
    }

    // Tests for addUser, updateUser, and delete methods would go here
}
