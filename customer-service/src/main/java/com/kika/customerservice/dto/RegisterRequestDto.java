package com.kika.customerservice.dto;

public record RegisterRequestDto (
        String username,
        String email,
        String password,
        String role
)
{}
