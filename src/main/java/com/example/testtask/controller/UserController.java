package com.example.testtask.controller;

import com.example.testtask.dto.JwtAuthenticationResponseDto;
import com.example.testtask.dto.UserRequestDto;
import com.example.testtask.dto.UserResponseDto;
import com.example.testtask.model.User;
import com.example.testtask.service.AuthenticationService;
import com.example.testtask.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final ObjectMapper mapper;

    @PostMapping("/add")
    public UserResponseDto add(@RequestBody UserRequestDto requestDto) {
        return mapper.convertValue(
                userService.add(mapper.convertValue(requestDto, User.class)), UserResponseDto.class);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtAuthenticationResponseDto> authenticateUser(@RequestBody UserRequestDto requestDto) {
        return ResponseEntity.ok(authenticationService.authenticate(requestDto));
    }
}
