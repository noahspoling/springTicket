package com.noahspoling.springTicket.controllers;

import com.noahspoling.springTicket.entity.Ticket;
import com.noahspoling.springTicket.entity.User;
import com.noahspoling.springTicket.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/ticket")
public class TicketController {
    private  final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(path = "/")
    public List<Ticket> getTickets() {
        return  ticketService.getAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Optional<Ticket> getTicket(@PathVariable("id") long id) {
        return ticketService.get(id);
    }

    @PostMapping(path = "/")
    @ResponseBody
    public void addTicket(@RequestBody Ticket ticket) {
        ticketService.save(ticket);
    }

    @PutMapping(path = "/{id}")
    @ResponseBody
    public void updateTicket(@PathVariable("id") long id,
                             @RequestBody Ticket ticket,
                             @RequestBody Map<String, Object> param)
            throws NoSuchFieldException, IllegalAccessException {
        ticketService.update(ticket, param);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public void deleteTicket(@PathVariable("id") long id,
                             @RequestBody Ticket ticket) {
        ticketService.delete(ticket);
    }
}
