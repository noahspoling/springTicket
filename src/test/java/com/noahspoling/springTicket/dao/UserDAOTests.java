package com.noahspoling.springTicket.dao;

import com.noahspoling.springTicket.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserIDAOTest {

    @Mock
    private EntityManager entityManager;
    @Mock
    private EntityTransaction transaction;
    @Mock
    private Query query;
    private UserIDAO dao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(entityManager.getTransaction()).thenReturn(transaction);
        dao = new UserIDAO();
    }

    @Test
    void testGet() {
        User expectedUser = new User();
        when(entityManager.find(User.class, 1L)).thenReturn(expectedUser);

        Optional<User> result = dao.get(1L);
        assertTrue(result.isPresent());
        assertEquals(expectedUser, result.get());
    }

    @Test
    void testGetAll() {
        User user1 = new User();
        User user2 = new User();
        List<User> expectedUsers = Arrays.asList(user1, user2);

        when(entityManager.createQuery("SELECT e from User e")).thenReturn(query);
        when(query.getResultList()).thenReturn(expectedUsers);

        List<User> result = dao.getAll();
        assertEquals(expectedUsers, result);
    }

    // Tests for save, update, and delete methods would go here

    // You might also want to test the login and signup methods, but they currently don't do anything
}
