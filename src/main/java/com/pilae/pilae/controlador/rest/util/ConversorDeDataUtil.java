package com.pilae.pilae.controlador.rest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConversorDeDataUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConversorDeDataUtil.class);

    private final ObjectMapper objectMapper;

    @Autowired
    public ConversorDeDataUtil(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public <T> String dtoToJson(final T dto) throws Exception {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
