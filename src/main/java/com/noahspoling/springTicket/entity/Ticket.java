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
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    private String ticketName;
    private String ticketDescription;
    @ManyToOne
    @JoinColumn(name = "createdBy", referencedColumnName = "userId")
    private Users userCreated;
    @ManyToOne
    @JoinColumn(name = "resolvedBy", referencedColumnName = "userId")
    private Users userResolved;

    public Ticket() {

    }
    public Ticket(long categoryId, String ticketName, String ticketDescription, long createdBy) {

    }



}
