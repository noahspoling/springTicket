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

}
