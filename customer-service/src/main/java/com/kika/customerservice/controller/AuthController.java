package com.kika.customerservice.controller;

import com.kika.customerservice.dto.LoginRequestDto;
import com.kika.customerservice.dto.RegisterRequestDto;
import com.kika.customerservice.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth")
public class AuthController {

    private final AuthService auth;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Регистрация")
    public void register(@RequestBody RegisterRequestDto dto) {
        auth.register(dto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Авторизация")
    public String login(@RequestBody LoginRequestDto dto) {
        return auth.login(dto);
    }
}

