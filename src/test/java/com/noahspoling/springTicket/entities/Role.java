package com.noahspoling.springTicket.entities;

import com.noahspoling.springTicket.entity.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    private Role role;

    @BeforeEach
    void setUp() {
        role = new Role("TestRole");
    }

    @Test
    void testNoArgConstructor() {
        Role noArgRole = new Role();
        assertNotNull(noArgRole);
    }

    @Test
    void testArgConstructor() {
        assertNotNull(role);
        assertEquals("TestRole", role.getRoleName());
    }

    @Test
    void testFullArgConstructor() {
        Role fullArgRole = new Role(1L, "TestRole");
        assertEquals(1L, fullArgRole.getRoleId());
        assertEquals("TestRole", fullArgRole.getRoleName());
    }

    @Test
    void testSetRoleId() {
        role.setRoleId(1L);
        assertEquals(1L, role.getRoleId());
    }

    @Test
    void testSetRoleName() {
        role.setRoleName("NewRole");
        assertEquals("NewRole", role.getRoleName());
    }
}
