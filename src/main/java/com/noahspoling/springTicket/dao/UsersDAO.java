package com.noahspoling.springTicket.dao;

import com.noahspoling.springTicket.entity.Users;

import java.util.List;

public interface UsersDAO {
    public List<Users> getUsers();
    public void addUser(Users user);
    public Users getUser(long id);
    public void deleteUser();
    public Users login();
    public Users signup();
}
