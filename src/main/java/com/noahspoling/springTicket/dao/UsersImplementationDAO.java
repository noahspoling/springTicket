package com.noahspoling.springTicket.dao;

import com.noahspoling.springTicket.entity.Users;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersImplementationDAO implements UsersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Users> getUsers() {
        return null;
    }

    @Override
    public void addUser(Users user) {

    }

    @Override
    public Users getUser(long id) {
        return null;
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public Users login() {
        return null;
    }

    @Override
    public Users signup() {
        return null;
    }
}
