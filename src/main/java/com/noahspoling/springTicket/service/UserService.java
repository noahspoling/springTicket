package com.noahspoling.springTicket.service;

import com.noahspoling.springTicket.dao.UserDAO;
import com.noahspoling.springTicket.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public Optional<Users> getUser(long id) {
        if(userDAO.get(id).isPresent()) {
            
        }
        return userDAO.get(id);
    }
    public List<Users> getUsers() {
        return userDAO.getAll();
    }
}
