package com.noahspoling.springTicket.entity;

//Role class entity for assigning privileges to users
//NOTE USERS USE ROLE BASED ACCESS NOT PERMISSION LEVEL

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
@Entity
@Table(name = "role")
public class Role {

    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
    )
    private long roleId;
    @Nonnull
    private String roleName;
    public Role() { };
    public Role(String roleName) {
        this.setRoleName(roleName);
    }
    public Role(long roleId, String roleName) {
        this.setRoleId(roleId);
        this.setRoleName(roleName);
    }
    public long getRoleId() {
        return roleId;
    }
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
    @Nonnull
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(@Nonnull String roleName) {
        this.roleName = roleName;
    }
}
