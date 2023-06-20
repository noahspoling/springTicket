package com.noahspoling.springTicket.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @SequenceGenerator(
            name = "ticket_sequence",
            sequenceName = "ticket_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_sequence"
    )
    private long ticketId;

    //Many tickets have one category
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    private String ticketName;
    private String ticketDescription;
    //Many tickets have one creator
    @ManyToOne
    @JoinColumn(name = "createdBy", referencedColumnName = "userId")
    private User userCreated;
    //Many tickets have one resolver
    @ManyToOne
    @JoinColumn(name = "resolvedBy", referencedColumnName = "userId")
    private User userResolved;

    public Ticket() {

    }
    //For creating unresolved ticket
    public Ticket(Category category, String ticketName, String ticketDescription, User userCreated) {
        this.setCategory(category);
        this.setTicketName(ticketName);
        this.setTicketDescription(ticketDescription);
        this.setUserCreated(userCreated);
    }

    //Getting existing unresolved ticket
    public Ticket(long ticketId, Category category, String ticketName, String ticketDescription, User userCreated) {
        this.setTicketId(ticketId);
        this.setCategory(category);
        this.setTicketName(ticketName);
        this.setTicketDescription(ticketDescription);
        this.setUserCreated(userCreated);
    }
    //Getting existing resolved ticket
    public Ticket(long ticketId, Category category, String ticketName, String ticketDescription, User userCreated, User userResolved) {
        this.setTicketId(ticketId);
        this.setCategory(category);
        this.setTicketName(ticketName);
        this.setTicketDescription(ticketDescription);
        this.setUserCreated(userCreated);
        this.setUserResolved(userResolved);
    }

    public long getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getTicketDescription() {
        return this.ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    public User getUserCreated() {
        return this.userCreated;
    }

    public void setUserCreated(User userCreated) {
        this.userCreated = userCreated;
    }

    public User getUserResolved() {
        return this.userResolved;
    }

    public void setUserResolved(User userResolved) {
        this.userResolved = userResolved;
    }
}
