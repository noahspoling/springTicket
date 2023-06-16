package com.noahspoling.springTicket.entities;

import com.noahspoling.springTicket.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoryTest {
    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category("Test Category");
    }

    @Test
    void testNoArgConstructor() {
        Category noArgCategory = new Category();
        assertNotNull(noArgCategory);
    }

    @Test
    void testArgConstructor() {
        assertNotNull(category);
        assertEquals("Test Category", category.getCategoryLabel());
    }

    @Test
    void testFullArgConstructor() {
        Category fullArgCategory = new Category(1L, "Full Test Category");
        assertEquals(1L, fullArgCategory.getCategoryId());
        assertEquals("Full Test Category", fullArgCategory.getCategoryLabel());
    }

    @Test
    void testSetCategoryId() {
        category.setCategoryId(1L);
        assertEquals(1L, category.getCategoryId());
    }

    @Test
    void testSetCategoryLabel() {
        category.setCategoryLabel("New Category Label");
        assertEquals("New Category Label", category.getCategoryLabel());
    }
}
