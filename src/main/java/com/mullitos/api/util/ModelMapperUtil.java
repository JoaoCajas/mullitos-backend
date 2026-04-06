package com.mullitos.api.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtil {

    private static ModelMapper mapper;

    // Inyección por constructor
    public ModelMapperUtil(ModelMapper mapper) {
        ModelMapperUtil.mapper = mapper;
    }

    public static <T> T convertTo(Object origin, Class<T> targetClass){
        if (origin == null) return null;
        return ModelMapperUtil.mapper.map(origin, targetClass);


    }
}