package com.noahspoling.springTicket.entities;


import com.noahspoling.springTicket.entity.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {
    private Users user;

    @BeforeEach
    void setUp() {
        user = new Users();
    }

    @Test
    void testNoArgConstructor() {
        assertNotNull(user);
    }

    @Test
    void testArgConstructor() {
        user = new Users("test@example.com", "testPassword");
        assertEquals("test@example.com", user.getEmail());
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    void testFullArgConstructor() {
        user = new Users(1L, "test@example.com", "testPassword");
        assertEquals(1L, user.getId());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    void testId() {
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    void testEmail() {
        user.setEmail("test@example.com");
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    void testInvalidEmail() {
        user.setEmail("test");
        assertNull(user.getEmail());
    }

    @Test
    void testLongEmail() {
        String longEmail = "test".repeat(100) + "@example.com"; // more than 255 chars
        user.setEmail(longEmail);
        assertNull(user.getEmail());
    }

    @Test
    void testPassword() {
        user.setPassword("testPassword");
        assertEquals("testPassword", user.getPassword());
    }
}
