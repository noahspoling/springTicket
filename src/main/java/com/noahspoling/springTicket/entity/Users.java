package com.noahspoling.springTicket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

//NOTE JAKARTA FOR SPRING 3 >
//EVERYTHING ELSE JAVAX
@Entity
@Table(name = "users")
public class Users {
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
    private String email;
    private String password;


    //Constructor overloading for multiple use cases
    //This might not be a good practice but the set Methods handles input requirements

    //No Argument Contructor
    public Users() {}
    //Constructors for handling logins.
    public Users(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

    public Users(long id, String email, String password) {
        this.setId(id);
        this.setEmail(email);
        this.setPassword(password);
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
    public void setId(long id) {
        this.userId = id;
    }

    public long getId() {
        return this.userId;
    }

    public void setEmail(String email) {

        //Simple email regex
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        //Limit string size to a
        if(email.length() > 255) {
            System.out.println("Email is over maximum of 255 characters");
        } else if (matcher.matches()) {
            this.email = email;
        } else {
            System.out.println("Failed regex test");
        }

    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    /*public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getRoleId() {
        return this.roleId;
    }*/

    @Override
    public String toString() {
        return "User{" +
                "id=" + (this.userId == 0 ? "null" : this.userId) +
                ", email='" + (this.email == null ? "null" : this.email) + '\'' +
                ", password='" + (this.password == null ? "null" : this.password) + '\'' +/*
                ", roleId=" + (this.roleId == 0 ? "null" : this.roleId) +
                ", dateCreated=" + (this.dateCreated == null ? "null" : this.dateCreated) +
                ", dateLastUpdated=" + (this.dateLastUpdated == null ? "null" : this.dateLastUpdated) +*/
                '}';
    }
}
