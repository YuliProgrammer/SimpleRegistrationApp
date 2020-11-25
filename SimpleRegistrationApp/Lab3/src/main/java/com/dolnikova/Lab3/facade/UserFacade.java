package com.dolnikova.Lab3.facade;

import javax.servlet.http.HttpServletRequest;

import com.dolnikova.Lab3.dto.UserCreateDto;
import com.dolnikova.Lab3.dto.UserLogInDto;
import com.dolnikova.Lab3.dto.UserViewDto;

public interface UserFacade {

    UserViewDto registerUser(UserCreateDto userCreateDto);

    UserViewDto loginUser(UserLogInDto userLogInDto);
}
