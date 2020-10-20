package com.dolnikova.Lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import com.dolnikova.Lab3.model.UserGender;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserViewDto {
    private String name;
    private String email;
    private LocalDate birthday;
    private String city;
    private String phoneNumber;
    private UserGender gender;
}
