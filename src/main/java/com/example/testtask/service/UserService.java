package com.example.testtask.service;

import com.example.testtask.model.User;

public interface UserService {
    User add(User user);

    User findByUsername(String username);
}
