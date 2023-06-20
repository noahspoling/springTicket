package com.noahspoling.springTicket.dao;

import com.noahspoling.springTicket.entity.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.*;

@Repository
public class UserDAO implements IDAO<User> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public List<User> getAll() {
        Query query = entityManager.createQuery("SELECT e from User e");
        return query.getResultList();
    }

    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }


    @Transactional
    @Override
    public void update(Optional<User> user, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException {
        for(Map.Entry<String, Object> entry: params.entrySet()) {
            Field field = User.class.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(user, entry.getValue());
        }
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }
}
