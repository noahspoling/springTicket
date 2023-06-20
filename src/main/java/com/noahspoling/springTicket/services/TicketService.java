package com.noahspoling.springTicket.services;

import com.noahspoling.springTicket.dao.TicketDAO;
import com.noahspoling.springTicket.dto.TicketRequest;
import com.noahspoling.springTicket.entity.Ticket;
import com.noahspoling.springTicket.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TicketService implements IService<Ticket, TicketRequest>{

    TicketDAO ticketDAO;

    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public Optional<Ticket> get(long id) {
        if(this.ticketDAO.get(id).isPresent()) {
            return this.ticketDAO.get(id);
        }
        return null;
    }

    public List<Ticket> getAll() {
        return this.ticketDAO.getAll();
    }

    public void save(TicketRequest ticket) {
        this.ticketDAO.save(ticket);
    }

    public void update(Optional<User> ticket, Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException {
        this.ticketDAO.update(ticket, params);
    }

    public void delete(Ticket ticket) {
        this.ticketDAO.delete(ticket);
    }
}
