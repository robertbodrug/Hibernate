package com.example.model;

import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 200, nullable = false)
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public Client() {
    }
}
