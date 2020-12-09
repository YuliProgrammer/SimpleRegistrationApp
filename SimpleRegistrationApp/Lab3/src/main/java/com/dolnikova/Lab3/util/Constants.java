package com.dolnikova.Lab3.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

    /**
     * Regular expression for password
     * Password should include at least 8 symbols, at least one upper case letters,
     * at least one digit.
     * Valid password examples:
     * '123456Qq', 'QWERTYq1', 'qwertyQ1', 'qwertyQ1_', 'QWERTYU1', '1234567Q';
     * Invalid password examples:
     * '12345678', 'QWERTYUI', 'qwertyui', '1234Qq', 'qwerQWER';
     */
    public static final String PASSWORD_REGEX = "(?!.*\\s)^(?=.*[A-Z])(?=.*[0-9]).{8,}$";

    /**
     * Regular expression for email
     * Valid email examples:
     * 'Name_Surname@email.com', 'Name_Surname1@email.com', 'someemail@email.com',
     * 'some-email@email.com', 'some-email@e-mail.com';
     * Invalid email examples:
     * 'Name+Surname1@email.com', 'someemailatemail.com', 'some-email@email.c';
     */
    public static final String EMAIL_REGEX = "^[A-z0-9.-]+[A-z0-9]@[A-z0-9][A-z0-9.-]+\\.[A-z]{2,}$";

    public static final String VALUE_CANNOT_BE_NULL = "Value cannot be null.";
    public static final String GENDER_IS_NOT_SELECTED_MESSAGE = "Please select your gender.";
    public static final String INVALID_EMAIL_MESSAGE = "Invalid email. Verify your input.";
    public static final String INVALID_PASSWORD_MESSAGE =
            "Password must contain at least one uppercase letter, one lowercase letter, one digit and at least 8 characters.";

    public final String EMAIL_ALREADY_EXISTS = "User with particular email already exists.";
    public final String CANNOT_AUTHENTICATE_USER = "Cannot authenticate user. Please check your data and try again.";
    public final String USER_NOT_FOUND = "User with particular email not found.";
    public final String PASSWORDS_DO_NOT_MATCH = "Passwords do not match.";
}
