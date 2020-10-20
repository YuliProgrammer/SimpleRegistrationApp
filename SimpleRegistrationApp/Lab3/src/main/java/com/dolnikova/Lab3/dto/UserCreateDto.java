package com.dolnikova.Lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.dolnikova.Lab3.model.UserGender;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    private String name;
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private String city;
    private String phoneNumber;
    private String password;
    private UserGender gender;
}
