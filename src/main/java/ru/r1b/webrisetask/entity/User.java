package ru.r1b.webrisetask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.annotations.ColumnTransformer;
import org.springframework.format.annotation.DateTimeFormat;
import ru.r1b.webrisetask.entity.converter.EntityCountConverter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User implements ResourceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Person name is required")
    private String name;

    @NotBlank(message = "Person email is required")
    @Email(message = "Person email has wrong format")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Person day of born is required")
    @Past(message = "Person day of born can't exceed today")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dayOfBorn;

    @Convert(converter = EntityCountConverter.class)
    @Column(columnDefinition = "jsonb")
    @ColumnTransformer(write = "?::jsonb")
    private Map<UUID, Integer> dishes = new HashMap<>();


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDayOfBorn() {
        return dayOfBorn;
    }

    public Map<UUID, Integer> getDishes() {
        return dishes;
    }
}
