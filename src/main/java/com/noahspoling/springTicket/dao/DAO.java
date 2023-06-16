package com.noahspoling.springTicket.dao;

import com.noahspoling.springTicket.entity.Users;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> get(long id);
    public List<T> getAll();
    public void save(Users user);
    public void update(T t, String[] params);

    void update(Users user, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException;

    public void delete(T t);
    public Users login();
    public Users signup();

    void setEntityManager(EntityManager entityManager);
}
