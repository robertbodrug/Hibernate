package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Planet {
    @Id
    @Column(name = "id",nullable = false)
    private String id;
    @Column(name = "name", length = 500, nullable = false)
    private String name;

    public Planet() {
    }
}
