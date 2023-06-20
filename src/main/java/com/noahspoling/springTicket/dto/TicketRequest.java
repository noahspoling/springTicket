package com.noahspoling.springTicket.dto;

import com.noahspoling.springTicket.dao.CategoryDAO;
import com.noahspoling.springTicket.entity.Category;
import com.noahspoling.springTicket.entity.Ticket;
import lombok.Data;
import lombok.Setter;

import java.util.Optional;

@Data
public class TicketRequest {

    private CategoryDAO categoryDAO;

    private long ticketId;
    private long categoryId;
    private String ticketName;
    private String ticketDescription;
    private long createdByUserId;
    private long resolvedByUserId;

    public TicketRequest() {

    }
    //For creating new Ticket
    public TicketRequest(long categoryId, String ticketName,
                         String ticketDescription, long createdByUserId) {
        this.categoryId = categoryId;
        this.ticketName = ticketName;
        this.ticketDescription = ticketDescription;
        this.createdByUserId = createdByUserId;
    }
    //getting unresolved ticket
    public TicketRequest(long ticketId, long categoryId, String ticketName,
                         String ticketDescription, long createdByUserId) {
        this.ticketId = ticketId;
        this.categoryId = categoryId;
        this.ticketName = ticketName;
        this.ticketDescription = ticketDescription;
        this.createdByUserId = createdByUserId;
    }
    //getting resolved ticket
    public TicketRequest(long ticketId, long categoryId, String ticketName,
                         String ticketDescription, long createdByUserId, long resolvedByUserId) {
        this.ticketId = ticketId;
        this.categoryId = categoryId;
        this.ticketName = ticketName;
        this.ticketDescription = ticketDescription;
        this.createdByUserId = createdByUserId;
        this.resolvedByUserId = resolvedByUserId;
    }

}
