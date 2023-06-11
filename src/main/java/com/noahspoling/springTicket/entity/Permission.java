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
    @Nonnull
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @Nonnull
    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
    @Nonnull
    private boolean canView;
    @Nonnull
    private boolean canEdit;
    @Nonnull
    private boolean canResolve;

    public Permission() {
    }
    public Permission(Category category, Role role, boolean canView, boolean canEdit, boolean canResolve) {
        this.setCategory(category);
        this.setRole(role);
        this.setCanView(canView);
        this.setCanEdit(canEdit);
        this.setCanResolve(canResolve);
    }

    public Permission(long permissionId, Category category, Role role, boolean canView, boolean canEdit, boolean canResolve) {
        this.setPermissionId(permissionId);
        this.setCategory(category);
        this.setRole(role);
        this.setCanView(canView);
        this.setCanEdit(canEdit);
        this.setCanResolve(canResolve);
    }

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isCanView() {
        return canView;
    }

    public void setCanView(boolean canView) {
        this.canView = canView;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public boolean isCanResolve() {
        return canResolve;
    }

    public void setCanResolve(boolean canResolve) {
        this.canResolve = canResolve;
    }
}
