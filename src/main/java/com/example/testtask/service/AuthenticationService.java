package com.example.testtask.service;

import com.example.testtask.dto.JwtAuthenticationResponseDto;
import com.example.testtask.dto.UserRequestDto;

public interface AuthenticationService {
    JwtAuthenticationResponseDto authenticate(UserRequestDto requestDto);
}
