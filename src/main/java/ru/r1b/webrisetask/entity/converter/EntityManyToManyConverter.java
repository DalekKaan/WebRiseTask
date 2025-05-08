package ru.r1b.webrisetask.entity.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

/**
 * Converter to present Set as JSON database field
 */
@Converter
public class EntityManyToManyConverter implements AttributeConverter<Set<UUID>, String> {

    private final ObjectMapper objectMapper;
    private final Logger logger;
    private final TypeReference<Set<UUID>> typeReference = new TypeReference<>() {
    };

    public EntityManyToManyConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.logger = LoggerFactory.getLogger(EntityManyToManyConverter.class);
    }

    @Override
    public String convertToDatabaseColumn(Set<UUID> set) {

        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(set);
        } catch (final JsonProcessingException e) {
            logger.error("JSON writing error", e);
        }

        return jsonString;
    }

    @Override
    public Set<UUID> convertToEntityAttribute(String jsonString) {

        Set<UUID> out = null;
        try {
            out = objectMapper.readValue(jsonString, typeReference);
        } catch (final IOException e) {
            logger.error("JSON reading error", e);
        }

        return out;
    }
}
