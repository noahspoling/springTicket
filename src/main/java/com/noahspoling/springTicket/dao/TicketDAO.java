package com.noahspoling.springTicket.dao;

import com.noahspoling.springTicket.entity.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class TicketDAO implements IDAO<Ticket> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Ticket> get(long id) {
        return Optional.ofNullable(entityManager.find(Ticket.class, id));
    }

    @Override
    public List<Ticket> getAll() {
        Query query = entityManager.createQuery("SELECT e from User e");
        return query.getResultList();
    }

    @Transactional
    @Override
    public void save(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Transactional
    @Override
    public void update(Ticket ticket, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException {
        for(Map.Entry<String, Object> entry: params.entrySet()) {
            Field field = Ticket.class.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(ticket, entry.getValue());
        }
        entityManager.merge(ticket);
    }

    @Transactional
    @Override
    public void delete(Ticket ticket) {
        entityManager.remove(ticket);
    }
}
