package com.dolnikova.Lab3.mapper;

import org.springframework.core.convert.converter.Converter;

import com.dolnikova.Lab3.model.UserGender;

public class StringToEnumMapper implements Converter<String, UserGender> {

    @Override
    public UserGender convert(String source) {
        return UserGender.valueOf(source.toUpperCase());
    }

}
