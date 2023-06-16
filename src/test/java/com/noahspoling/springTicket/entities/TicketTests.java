package com.noahspoling.springTicket.entities;


import com.noahspoling.springTicket.entity.Ticket;
import com.noahspoling.springTicket.entity.User;
import com.noahspoling.springTicket.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    private Ticket ticket;
    private User userCreated, userResolved;
    private Category category;

    @BeforeEach
    void setUp() {
        userCreated = new User("created@example.com", "createdPassword");
        userResolved = new User("resolved@example.com", "resolvedPassword");
        category = new Category(); // assuming Category has a no-arg constructor
        ticket = new Ticket(category, "Test Ticket", "Test Description", userCreated);
    }

    @Test
    void testNoArgConstructor() {
        Ticket noArgTicket = new Ticket();
        assertNotNull(noArgTicket);
    }

    @Test
    void testArgConstructor() {
        assertNotNull(ticket);
        assertEquals(category, ticket.getCategory());
        assertEquals("Test Ticket", ticket.getTicketName());
        assertEquals("Test Description", ticket.getTicketDescription());
        assertEquals(userCreated, ticket.getUserCreated());
        assertNull(ticket.getUserResolved());
    }

    @Test
    void testFullArgConstructor() {
        Ticket fullArgTicket = new Ticket(1L, category, "Test Ticket", "Test Description", userCreated, userResolved);
        assertEquals(1L, fullArgTicket.getTicketId());
        assertEquals(category, fullArgTicket.getCategory());
        assertEquals("Test Ticket", fullArgTicket.getTicketName());
        assertEquals("Test Description", fullArgTicket.getTicketDescription());
        assertEquals(userCreated, fullArgTicket.getUserCreated());
        assertEquals(userResolved, fullArgTicket.getUserResolved());
    }

    @Test
    void testSetTicketId() {
        ticket.setTicketId(1L);
        assertEquals(1L, ticket.getTicketId());
    }

    @Test
    void testSetCategory() {
        Category newCategory = new Category(); // assuming Category has a no-arg constructor
        ticket.setCategory(newCategory);
        assertEquals(newCategory, ticket.getCategory());
    }

    @Test
    void testSetTicketName() {
        ticket.setTicketName("New Ticket Name");
        assertEquals("New Ticket Name", ticket.getTicketName());
    }

    @Test
    void testSetTicketDescription() {
        ticket.setTicketDescription("New Ticket Description");
        assertEquals("New Ticket Description", ticket.getTicketDescription());
    }

    @Test
    void testSetUserCreated() {
        User newUserCreated = new User("newCreated@example.com", "newCreatedPassword");
        ticket.setUserCreated(newUserCreated);
        assertEquals(newUserCreated, ticket.getUserCreated());
    }

    @Test
    void testSetUserResolved() {
        User newUserResolved = new User("newResolved@example.com", "newResolvedPassword");
        ticket.setUserResolved(newUserResolved);
        assertEquals(newUserResolved, ticket.getUserResolved());
    }
}