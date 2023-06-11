package com.noahspoling.springTicket.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "permission_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    private long categoryId;
    @Nonnull
    private String categoryLabel;

    public Category() { }
    public Category(String categoryLabel) {
        this.setCategoryLabel(categoryLabel);
    }
    public Category(long categoryId, String categoryLabel) {
        this.setCategoryId(categoryId);
        this.setCategoryLabel(categoryLabel);
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Nonnull
    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(@Nonnull String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }
}
