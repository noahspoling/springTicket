package com.noahspoling.springTicket.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IDAO<T> {
    public Optional<T> get(long id);
    public List<T> getAll();
    public void save(T t);

    public void update(T t, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException;

    public void delete(T t);
}
