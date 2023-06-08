package com.noahspoling.springTicket.lib.user;

import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class User {
    private long id;
    private String email;
    private String password;
    private long roleId;
    private Date dateCreated;
    private Date dateLastUpdated;


    //Constructor overloading for multiple use cases
    //This might not be a good practice but the set Methods handles input requirements

    //No Argument Contructor
    public User() {

    }
    //Constructors for handling logins.
    public User(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

    //For routes that need a list of users. includes roleId for sql joins do get list based on role
    public User(long id, String email, long roleId) {
        this.setId(id);
        this.setEmail(email);
        this.setRoleId(roleId);
    }

    //Returns on login success
    public User(long id, String email, String password, long roleId) {
        this.setId(id);
        this.setEmail(email);
        this.setPassword(password);
        this.setRoleId(roleId);
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
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
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getRoleId() {
        return roleId;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + (this.id == 0 ? "null" : this.id) +
                ", email='" + (this.email == null ? "null" : this.email) + '\'' +
                ", password='" + (this.password == null ? "null" : this.password) + '\'' +
                ", roleId=" + (this.roleId == 0 ? "null" : this.roleId) +
                ", dateCreated=" + (this.dateCreated == null ? "null" : this.dateCreated) +
                ", dateLastUpdated=" + (this.dateLastUpdated == null ? "null" : this.dateLastUpdated) +
                '}';
    }
}
