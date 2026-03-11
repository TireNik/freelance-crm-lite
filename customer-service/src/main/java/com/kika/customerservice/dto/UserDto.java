package com.kika.customerservice.dto;

import com.kika.customerservice.entity.User;
import lombok.Value;

/**
 * DTO for {@link User}
 */
@Value
public class UserDto {
    Long id;
    String username;
}