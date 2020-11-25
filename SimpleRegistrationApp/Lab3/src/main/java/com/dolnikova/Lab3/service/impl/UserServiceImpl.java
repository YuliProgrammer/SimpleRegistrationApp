package com.dolnikova.Lab3.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dolnikova.Lab3.exception.UserAlreadyExists;
import com.dolnikova.Lab3.exception.UserNotFoundException;
import com.dolnikova.Lab3.model.User;
import com.dolnikova.Lab3.repository.UserRepository;
import com.dolnikova.Lab3.service.UserService;
import com.dolnikova.Lab3.util.Constants;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User newUser) {
        verifyExistingEmail(newUser);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    @Override
    public User loginUser(User user) {
        User foundUser = userRepository.findByEmail(user.getEmail()).orElseThrow(() -> {
            throw new UserNotFoundException(Constants.USER_NOT_FOUND);
        });

        if (!passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            throw new UserNotFoundException(Constants.PASSWORDS_DO_NOT_MATCH);
        }

        return foundUser;
    }

    private void verifyExistingEmail(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExists(Constants.EMAIL_ALREADY_EXISTS);
        }
    }

}
