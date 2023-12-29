package com.example.testtask.service.impl;

import com.example.testtask.exception.DataProcessingException;
import com.example.testtask.model.User;
import com.example.testtask.repository.UserRepository;
import com.example.testtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new DataProcessingException("Can`t find user by username: " + username)
        );
    }
}
