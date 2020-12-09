package com.dolnikova.Lab3.dto;

import static com.dolnikova.Lab3.util.Constants.EMAIL_REGEX;
import static com.dolnikova.Lab3.util.Constants.INVALID_EMAIL_MESSAGE;
import static com.dolnikova.Lab3.util.Constants.INVALID_PASSWORD_MESSAGE;
import static com.dolnikova.Lab3.util.Constants.PASSWORD_REGEX;
import static com.dolnikova.Lab3.util.Constants.VALUE_CANNOT_BE_NULL;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserLogInDto {

    @NotNull(message = VALUE_CANNOT_BE_NULL)
    @Pattern(regexp = EMAIL_REGEX, message = INVALID_EMAIL_MESSAGE)
    private String email;

    @NotNull(message = VALUE_CANNOT_BE_NULL)
    @Pattern(regexp = PASSWORD_REGEX, message = INVALID_PASSWORD_MESSAGE)
    private String password;
}