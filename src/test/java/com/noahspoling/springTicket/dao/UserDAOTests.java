package com.noahspoling.springTicket.dao;

import com.noahspoling.springTicket.entity.Users;
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

class UserDAOTest {

    @Mock
    private EntityManager entityManager;
    @Mock
    private EntityTransaction transaction;
    @Mock
    private Query query;
    private UserDAO dao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(entityManager.getTransaction()).thenReturn(transaction);
        dao = new UserDAO();
        dao.setEntityManager(entityManager);
    }

    @Test
    void testGet() {
        Users expectedUser = new Users();
        when(entityManager.find(Users.class, 1L)).thenReturn(expectedUser);

        Optional<Users> result = dao.get(1L);
        assertTrue(result.isPresent());
        assertEquals(expectedUser, result.get());
    }

    @Test
    void testGetAll() {
        Users user1 = new Users();
        Users user2 = new Users();
        List<Users> expectedUsers = Arrays.asList(user1, user2);

        when(entityManager.createQuery("SELECT e from User e")).thenReturn(query);
        when(query.getResultList()).thenReturn(expectedUsers);

        List<Users> result = dao.getAll();
        assertEquals(expectedUsers, result);
    }

    // Tests for save, update, and delete methods would go here

    // You might also want to test the login and signup methods, but they currently don't do anything
}
