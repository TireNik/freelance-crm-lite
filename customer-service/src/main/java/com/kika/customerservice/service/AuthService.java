package com.kika.customerservice.service;

import com.kika.customerservice.dto.LoginRequestDto;
import com.kika.customerservice.dto.RegisterRequestDto;

public interface AuthService {
    void register(RegisterRequestDto dto);

    String login(LoginRequestDto dto);
}
