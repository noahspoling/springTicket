package com.noahspoling.springTicket.service;

import com.noahspoling.springTicket.dao.UserDAO;
import com.noahspoling.springTicket.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Optional<Users> getUser(long id) {
        if(userDAO.get(id).isPresent()) {
            return userDAO.get(id);
        }
        return null;
    }
    public List<Users> getUsers() {
        return userDAO.getAll();
    }
    public void addUser(Users user) {
        userDAO.save(user);
    }
    public void updateUser(Users user, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException {
        userDAO.update(user, params);
    }
    public void delete(Users user) { userDAO.delete(user); }
}
