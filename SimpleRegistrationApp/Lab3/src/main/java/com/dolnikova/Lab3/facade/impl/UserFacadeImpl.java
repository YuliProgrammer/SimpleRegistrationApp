package com.dolnikova.Lab3.facade.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.dolnikova.Lab3.dto.UserCreateDto;
import com.dolnikova.Lab3.dto.UserLogInDto;
import com.dolnikova.Lab3.dto.UserViewDto;
import com.dolnikova.Lab3.exception.PasswordsDoNotMatch;
import com.dolnikova.Lab3.facade.UserFacade;
import com.dolnikova.Lab3.mapper.UserCreateDtoMapper;
import com.dolnikova.Lab3.mapper.UserLogInMapper;
import com.dolnikova.Lab3.mapper.UserViewDtoMapper;
import com.dolnikova.Lab3.model.User;
import com.dolnikova.Lab3.service.UserService;
import com.dolnikova.Lab3.util.Constants;

@Slf4j
@Service
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;

    private final UserLogInMapper userLogInMapper;
    private final UserViewDtoMapper userViewDtoMapper;
    private final UserCreateDtoMapper userCreateDtoMapper;

    @Override
    public UserViewDto registerUser(UserCreateDto userCreateDto) {
        if (!userCreateDto.getPassword().equals(userCreateDto.getConfirmPassword())) {
            throw new PasswordsDoNotMatch(Constants.PASSWORDS_DO_NOT_MATCH);
        }
        User user = userCreateDtoMapper.convert(userCreateDto);
        return userViewDtoMapper.convert(userService.registerUser(user));
    }

    @Override
    public UserViewDto loginUser(UserLogInDto userLogInDto) {
        User user = userService.loginUser(userLogInMapper.convert(userLogInDto));
        return userViewDtoMapper.convert(user);
    }

}
