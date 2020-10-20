package com.dolnikova.Lab3.mapper;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dolnikova.Lab3.dto.UserCreateDto;
import com.dolnikova.Lab3.dto.UserViewDto;

@Component
@AllArgsConstructor
public class UserViewDtoMapper implements Converter<UserCreateDto, UserViewDto> {

    private final ModelMapper modelMapper;

    @Override
    public UserViewDto convert(UserCreateDto userCreateDto) {
        return modelMapper.map(userCreateDto, UserViewDto.class);
    }
}

