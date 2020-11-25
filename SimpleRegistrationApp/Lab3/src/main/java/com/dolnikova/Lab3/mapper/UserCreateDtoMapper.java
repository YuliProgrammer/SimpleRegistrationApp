package com.dolnikova.Lab3.mapper;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dolnikova.Lab3.dto.UserCreateDto;
import com.dolnikova.Lab3.model.User;
import com.dolnikova.Lab3.repository.CityRepository;
import com.dolnikova.Lab3.repository.GenderRepository;

@Component
@AllArgsConstructor
public class UserCreateDtoMapper implements Converter<UserCreateDto, User> {

    private final ModelMapper modelMapper;
    private final GenderRepository genderRepository;
    private final CityRepository cityRepository;

    @Override
    public User convert(UserCreateDto userCreateDto) {
        User user = modelMapper.map(userCreateDto, User.class);
        user.setGender(genderRepository.findByUserGender(userCreateDto.getUserGender()));
        user.setCity(cityRepository.findByCity(userCreateDto.getCity()));
        return user;
    }

}

