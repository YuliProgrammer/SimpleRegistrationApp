package com.dolnikova.Lab3.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dolnikova.Lab3.dto.UserCreateDto;
import com.dolnikova.Lab3.dto.UserLogInDto;
import com.dolnikova.Lab3.dto.UserViewDto;
import com.dolnikova.Lab3.facade.UserFacade;

@Slf4j
@Controller
@AllArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/profile")
    public String profilePage() {
        return "profile";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user") UserCreateDto userCreateDto, Model model) {
        model.addAttribute("user", userFacade.registerUser(userCreateDto));
        return "redirect:/login";
    }

    @PostMapping("/perform_login")
    public String loginUser(@ModelAttribute("user") UserLogInDto userLogInDto, Model model,
            HttpServletRequest request) {
        UserViewDto user = userFacade.loginUser(userLogInDto);
        model.addAttribute("user", user);

        return "profile";
    }

}
