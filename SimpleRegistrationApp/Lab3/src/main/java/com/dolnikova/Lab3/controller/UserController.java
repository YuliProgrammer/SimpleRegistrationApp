package com.dolnikova.Lab3.controller;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dolnikova.Lab3.dto.UserCreateDto;
import com.dolnikova.Lab3.mapper.UserViewDtoMapper;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserViewDtoMapper userViewDtoMapper;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserCreateDto user, Model model) {
        model.addAttribute("user", userViewDtoMapper.convert(user));
        return "profile";
    }

}
