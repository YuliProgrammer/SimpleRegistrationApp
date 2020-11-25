package com.dolnikova.Lab3.mapper;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dolnikova.Lab3.dto.UserLogInDto;
import com.dolnikova.Lab3.model.User;

@Component
@AllArgsConstructor
public class UserLogInMapper implements Converter<UserLogInDto, User> {

    private final ModelMapper modelMapper;

    @Override
    public User convert(UserLogInDto userLogInDto) {
        return modelMapper.map(userLogInDto, User.class);
    }

}
