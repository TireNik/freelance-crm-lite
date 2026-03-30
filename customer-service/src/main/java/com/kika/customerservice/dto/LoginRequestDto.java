package com.kika.customerservice.dto;

public record LoginRequestDto(
        String email,
        String password
) {
}
