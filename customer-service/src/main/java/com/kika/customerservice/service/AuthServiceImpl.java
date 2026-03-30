package com.kika.customerservice.service;

import com.kika.customerservice.dto.LoginRequestDto;
import com.kika.customerservice.dto.RegisterRequestDto;
import com.kika.customerservice.entity.Role;
import com.kika.customerservice.entity.User;
import com.kika.customerservice.repository.UserRepository;
import com.kika.customerservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public void register(RegisterRequestDto dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("User already exists");
        }

        User user = User.builder()
                .username(dto.username())
                .email(dto.email())
                .passwordHash(passwordEncoder.encode(dto.password()))
                .role(Role.valueOf(dto.role()))
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }

    @Override
    public String login(LoginRequestDto dto) {
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if (!passwordEncoder.matches(dto.password(), user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid Credentials");
        }

        return jwtService.generateToken(user);
    }
}
