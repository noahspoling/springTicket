package com.noahspoling.springTicket.entities;


import com.noahspoling.springTicket.entity.Category;
import com.noahspoling.springTicket.entity.Permission;
import com.noahspoling.springTicket.entity.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermissionTest {

    private Permission permission;
    private Category testCategory;
    private Role testRole;

    @BeforeEach
    void setUp() {
        testCategory = new Category(1L, "TestCategory");
        testRole = new Role(1L, "TestRole");
        permission = new Permission(testCategory, testRole, true, true, true);
    }

    @Test
    void testNoArgConstructor() {
        Permission noArgPermission = new Permission();
        assertNotNull(noArgPermission);
    }

    @Test
    void testArgConstructor() {
        assertNotNull(permission);
        assertEquals(testCategory, permission.getCategory());
        assertEquals(testRole, permission.getRole());
        assertTrue(permission.isCanView());
        assertTrue(permission.isCanEdit());
        assertTrue(permission.isCanResolve());
    }

    @Test
    void testFullArgConstructor() {
        Permission fullArgPermission = new Permission(1L, testCategory, testRole, true, false, true);
        assertEquals(1L, fullArgPermission.getPermissionId());
        assertEquals(testCategory, fullArgPermission.getCategory());
        assertEquals(testRole, fullArgPermission.getRole());
        assertTrue(fullArgPermission.isCanView());
        assertFalse(fullArgPermission.isCanEdit());
        assertTrue(fullArgPermission.isCanResolve());
    }

    @Test
    void testSetPermissionId() {
        permission.setPermissionId(1L);
        assertEquals(1L, permission.getPermissionId());
    }

    @Test
    void testSetCategory() {
        Category newCategory = new Category(2L, "NewCategory");
        permission.setCategory(newCategory);
        assertEquals(newCategory, permission.getCategory());
    }

    @Test
    void testSetRole() {
        Role newRole = new Role(2L, "NewRole");
        permission.setRole(newRole);
        assertEquals(newRole, permission.getRole());
    }

    @Test
    void testSetCanView() {
        permission.setCanView(false);
        assertFalse(permission.isCanView());
    }

    @Test
    void testSetCanEdit() {
        permission.setCanEdit(false);
        assertFalse(permission.isCanEdit());
    }

    @Test
    void testSetCanResolve() {
        permission.setCanResolve(false);
        assertFalse(permission.isCanResolve());
    }
}
