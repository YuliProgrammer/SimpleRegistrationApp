package com.dolnikova.Lab3.dto;

import static com.dolnikova.Lab3.util.Constants.EMAIL_REGEX;
import static com.dolnikova.Lab3.util.Constants.GENDER_IS_NOT_SELECTED_MESSAGE;
import static com.dolnikova.Lab3.util.Constants.INVALID_EMAIL_MESSAGE;
import static com.dolnikova.Lab3.util.Constants.INVALID_PASSWORD_MESSAGE;
import static com.dolnikova.Lab3.util.Constants.PASSWORD_REGEX;
import static com.dolnikova.Lab3.util.Constants.VALUE_CANNOT_BE_NULL;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.dolnikova.Lab3.model.UserGender;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {

    @NotNull(message = VALUE_CANNOT_BE_NULL)
    private String name;

    @NotNull(message = VALUE_CANNOT_BE_NULL)
    @Pattern(regexp = EMAIL_REGEX, message = INVALID_EMAIL_MESSAGE)
    private String email;

    @NotNull(message = VALUE_CANNOT_BE_NULL)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotNull(message = VALUE_CANNOT_BE_NULL)
    private String city;

    @NotNull(message = VALUE_CANNOT_BE_NULL)
    private String phoneNumber;

    @NotNull(message = VALUE_CANNOT_BE_NULL)
    @Pattern(regexp = PASSWORD_REGEX, message = INVALID_PASSWORD_MESSAGE)
    private String password;

    @NotNull(message = VALUE_CANNOT_BE_NULL)
    @Pattern(regexp = PASSWORD_REGEX, message = INVALID_PASSWORD_MESSAGE)
    private String confirmPassword;

    @NotNull(message = GENDER_IS_NOT_SELECTED_MESSAGE)
    private UserGender userGender;
}
