package com.noahspoling.springTicket.dao;

import com.noahspoling.springTicket.entity.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Consumer;

@Repository
public class UserDAO implements DAO<User> {


    //private EntityManagerFactory entityManagerFactory;
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

    @Override
    public void update(User user, String[] params) {

    }

    @Transactional
    @Override
    public void update(User user, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException {
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

    @Override
    public User login() {
        return null;
    }

    @Override
    public User signup() {
        return null;
    }

    /*private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            action.accept(entityManager);
            transaction.commit();
        }
        catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        }
    }*/
}
