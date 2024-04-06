package com.example.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "created_at",insertable = false)
    private LocalDate createAt;

    @ManyToOne()
    @JoinColumn(name = "client_id" ,nullable = false)
    private Client client;

    @ManyToOne()
    @JoinColumn(name = "from_planet_id",nullable = false)
    private Planet planetFrom;
    @ManyToOne()
    @JoinColumn(name = "to_planet_id",nullable = false)
    private Planet planetTo;


    @Override
    public String toString() {
        return "Ticket{ " +
                "id= " + id +
                ", client= " + client.getId() +
                ", createAt= " + createAt +
                ", planetFrom= " + planetFrom.getName() +
                ", planetTo= " + planetTo.getName() +
                '}';
    }

    public Ticket() {
    }

    public Ticket(Client client, Planet planetFrom, Planet planetTo) {
        this.client = client;
        this.planetFrom = planetFrom;
        this.planetTo = planetTo;
    }
}
