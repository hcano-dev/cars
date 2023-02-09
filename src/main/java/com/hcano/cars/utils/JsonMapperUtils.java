package com.hcano.cars.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapperUtils {
    private JsonMapperUtils() { }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String mapToJson(Object o) throws JsonProcessingException {
        return objectMapper.writeValueAsString(o);
    }
}
