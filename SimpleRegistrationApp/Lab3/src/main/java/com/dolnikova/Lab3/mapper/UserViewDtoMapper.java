package com.dolnikova.Lab3.mapper;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dolnikova.Lab3.dto.UserViewDto;
import com.dolnikova.Lab3.model.User;

@Component
@AllArgsConstructor
public class UserViewDtoMapper implements Converter<User, UserViewDto> {

    private final ModelMapper modelMapper;

    @Override
    public UserViewDto convert(User user) {
        UserViewDto userViewDto = modelMapper.map(user, UserViewDto.class);
        userViewDto.setCity(user.getCity().getCity());
        return userViewDto;
    }

}

