package com.noahspoling.springTicket.services;

import com.noahspoling.springTicket.entity.User;

import java.util.Optional;
import java.util.List;
import java.util.Map;

public interface IService<T, R> {
    public Optional<T> get(long id);

    public List<T> getAll();

    public void save(R t);

    public void update(Optional<User> t, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException;

    public void delete(T t);
}
