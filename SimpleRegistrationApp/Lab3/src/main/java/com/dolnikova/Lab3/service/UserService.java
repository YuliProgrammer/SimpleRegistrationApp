package com.dolnikova.Lab3.service;

import com.dolnikova.Lab3.model.User;

public interface UserService {

    User registerUser(User newUser);

    User loginUser(User user);

}
