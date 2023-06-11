package com.noahspoling.springTicket.entity;

//Class Entity that assigns privileges to a role and category.

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @SequenceGenerator(
            name = "permission_sequence",
            sequenceName = "permission_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "permission_sequence"
    )
    private long permissionId;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
    @Nonnull
    private boolean canView;
    @Nonnull
    private boolean canEdit;
    @Nonnull
    private boolean canResolve;

    /*public Permission() {
    }
    public Permission() {
    }*/
}
