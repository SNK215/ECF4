package com.example.ecf4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private String description;
    private String photoUrl;
    private int celestialObjectId;

    public Observation(String description, String photoUrl, int celestialObjectId) {
        this.date = LocalDate.now();
        this.description = description;
        this.photoUrl = photoUrl;
        this.celestialObjectId = celestialObjectId;
    }

    public Observation(int id, String description, String photoUrl, int celestialObjectId) {
        this.id = id;
        this.date = LocalDate.now();
        this.description = description;
        this.photoUrl = photoUrl;
        this.celestialObjectId = celestialObjectId;
    }
}
