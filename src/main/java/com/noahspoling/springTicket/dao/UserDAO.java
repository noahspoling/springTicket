package com.noahspoling.springTicket.dao;

import com.noahspoling.springTicket.entity.Users;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Consumer;

@Repository
public class UserDAO implements DAO<Users> {


    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private EntityManager entityManager;

    public UserDAO () {
        this.setEntityManager(entityManager);
    }

    @Override
    public Optional<Users> get(long id) {
        return Optional.ofNullable(entityManager.find(Users.class, id));
    }

    @Override
    public List<Users> getAll() {
        Query query = entityManager.createQuery("SELECT e from User e");
        return query.getResultList();
    }

    @Override
    public void save(Users user) {
        executeInsideTransaction(entityManager -> entityManager.persist(user));
    }

    @Override
    public void update(Users users, String[] params) {

    }

    @Override
    public void update(Users user, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException {
        for(Map.Entry<String, Object> entry: params.entrySet()) {
            Field field = Users.class.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(user, entry.getValue());
        }
        executeInsideTransaction(entityManager -> entityManager.merge(user));
    }

    @Override
    public void delete(Users user) {
        executeInsideTransaction(entityManager -> entityManager.remove(user));
    }

    @Override
    public Users login() {
        return null;
    }

    @Override
    public Users signup() {
        return null;
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
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
    }
}
