package com.example.testtask.service.impl;

import com.example.testtask.dto.JwtAuthenticationResponseDto;
import com.example.testtask.dto.UserRequestDto;
import com.example.testtask.exception.CustomAuthenticationException;
import com.example.testtask.security.JwtService;
import com.example.testtask.service.AuthenticationService;
import com.example.testtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Override
    public JwtAuthenticationResponseDto authenticate(UserRequestDto requestDto) {
        var user = userService.findByUsername(requestDto.username());
        if (!passwordEncoder.matches(requestDto.password(), user.getPassword())) {
            throw new CustomAuthenticationException("Invalid email or password");
        }
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponseDto.builder().token(jwt).build();
    }
}
