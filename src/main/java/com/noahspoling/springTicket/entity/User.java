package com.noahspoling.springTicket.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

//NOTE JAKARTA FOR SPRING 3 >
//EVERYTHING ELSE JAVAX
@Data
@Entity
@Table(name = "_user")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long userId;
    @Column(unique = true)
    private String email;
    private String password;


    //Constructor overloading for multiple use cases
    //This might not be a good practice but the set Methods handles input requirements

    //No Argument Contructor
    public User() {}
    //Constructors for handling logins.
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(long id, String email, String password) {
        this.userId = id;
        this.email = email;
        this.password = password;
    }

    //For routes that need a list of users. includes roleId for sql joins do get list based on role
    /*public Users(long id, String email, long roleId) {
        this.setId(id);
        this.setEmail(email);
        this.setRoleId(roleId);
    }*/

    //Returns on login success
    /*public Users(long id, String email, String password, long roleId) {
        this.setId(id);
        this.setEmail(email);
        this.setPassword(password);
        this.setRoleId(roleId);
    }*/
}
