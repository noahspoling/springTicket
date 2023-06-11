package com.noahspoling.springTicket.dao;

import com.noahspoling.springTicket.entity.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

@Repository
public class UserDAO implements DAO<Users> {

    @Autowired
    private EntityManager entityManager;

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
    public void update(Users user, String[] params) {
        user.setEmail(Objects.requireNonNull(params[0], "Email cannot be null"));
        user.setPassword(Objects.requireNonNull(params[1], "Password cannot be null"));
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
