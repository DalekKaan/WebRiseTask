package ru.r1b.webrisetask.entity.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Converter to present Set as JSON database field
 * @param <V> json value type
 */
@Converter
public class CommonHashSetConverter<V> implements AttributeConverter<Set<V>, String> {

    private final ObjectMapper objectMapper;
    private final Logger logger;
    private final TypeReference<HashSet<V>> typeReference = new TypeReference<>() {
    };

    public CommonHashSetConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.logger = LoggerFactory.getLogger(CommonHashSetConverter.class);
    }

    @Override
    public String convertToDatabaseColumn(Set<V> set) {

        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(set);
        } catch (final JsonProcessingException e) {
            logger.error("JSON writing error", e);
        }

        return jsonString;
    }

    @Override
    public Set<V> convertToEntityAttribute(String jsonString) {

        Set<V> out = null;
        try {
            out = objectMapper.readValue(jsonString, typeReference);
        } catch (final IOException e) {
            logger.error("JSON reading error", e);
        }

        return out;
    }
}
