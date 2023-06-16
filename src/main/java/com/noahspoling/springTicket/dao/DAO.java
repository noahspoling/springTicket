package com.noahspoling.springTicket.dao;

import com.noahspoling.springTicket.entity.User;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> get(long id);
    public List<T> getAll();
    public void save(User user);
    public void update(T t, String[] params);

    void update(User user, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException;

    public void delete(T t);
    public User login();
    public User signup();
}
