package com.noahspoling.springTicket.services;

import com.noahspoling.springTicket.dao.UserDAO;
import com.noahspoling.springTicket.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService implements IService<User>{

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Optional<User> get(long id) {
        if(this.userDAO.get(id).isPresent()) {
            return this.userDAO.get(id);
        }
        return null;
    }
    public List<User> getAll() {
        return this.userDAO.getAll();
    }
    public void save(User user) {
        this.userDAO.save(user);
    }
    public void update(User user, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException {
        this.userDAO.update(user, params);
    }
    public void delete(User user) {
        this.userDAO.delete(user);
    }
}
