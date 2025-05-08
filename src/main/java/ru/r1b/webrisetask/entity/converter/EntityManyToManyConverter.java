package ru.r1b.webrisetask.entity.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

public class EntityManyToManyConverter extends CommonHashSetConverter<UUID> {
    public EntityManyToManyConverter(ObjectMapper objectMapper) {
        super(objectMapper);
    }
}
