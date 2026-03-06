package com.kika.customerservice.dto;

import com.kika.customerservice.entity.Role;
import com.kika.customerservice.entity.User;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * DTO for {@link User}
 */
@Value
public class UserDtoResponse {
    Long id;
    String username;
    String email;
    Role role;
    LocalDateTime createdAt;
}