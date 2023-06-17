package com.noahspoling.springTicket.services;

import java.util.Optional;
import java.util.List;
import java.util.Map;

public interface IService<T> {
    public Optional<T> get(long id);

    public List<T> getAll();

    public void save(T t);

    public void update(T t, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException;

    public void delete(T t);
}
