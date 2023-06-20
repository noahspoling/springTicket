package com.noahspoling.springTicket.dao;

import com.noahspoling.springTicket.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Interface for my
 * @param <T>
 */
public interface IDAO<T> {
    public Optional<T> get(long id);
    public List<T> getAll();
    public void save(T t);

    public void update(Optional<User> user, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException;

    public void delete(T t);
}
