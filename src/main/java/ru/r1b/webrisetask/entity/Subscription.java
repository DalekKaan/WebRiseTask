package ru.r1b.webrisetask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name = "subscriptions")
public class Subscription implements ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Service name is required")
    private String name;

    @Override
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
