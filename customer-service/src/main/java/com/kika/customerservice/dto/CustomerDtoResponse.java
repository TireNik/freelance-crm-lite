package com.kika.customerservice.dto;

import com.kika.customerservice.entity.Customer;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * DTO for {@link Customer}
 */
@Value
public class CustomerDtoResponse {
    Long id;
    String firstName;
    String lastName;
    String email;
    String phone;
    String company;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}