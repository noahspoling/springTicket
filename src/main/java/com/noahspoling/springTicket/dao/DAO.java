package com.noahspoling.springTicket.dao;

import com.noahspoling.springTicket.entity.Users;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> get(long id);
    public List<T> getAll();
    public void save(Users user);
    public void update(T t, String[] params);
    public void delete(T t);
    public Users login();
    public Users signup();
}
