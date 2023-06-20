package com.noahspoling.springTicket.dao;

import com.noahspoling.springTicket.entity.Category;
import com.noahspoling.springTicket.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CategoryDAO implements IDAO<Category> {

    @Override
    public Optional<Category> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void update(Optional<User> user, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException {

    }

    @Override
    public void delete(Category category) {

    }
}
