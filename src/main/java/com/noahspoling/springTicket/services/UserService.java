package com.noahspoling.springTicket.services;

import com.noahspoling.springTicket.dao.UserDAO;
import com.noahspoling.springTicket.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Optional<User> getUser(long id) {
        if(userDAO.get(id).isPresent()) {
            return userDAO.get(id);
        }
        return null;
    }
    public List<User> getUsers() {
        return userDAO.getAll();
    }
    public void addUser(User user) {
        userDAO.save(user);
    }
    public void updateUser(User user, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException {
        userDAO.update(user, params);
    }
    public void delete(User user) { userDAO.delete(user); }
}
