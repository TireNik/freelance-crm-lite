package com.kika.customerservice.dto;

import com.kika.customerservice.entity.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for {@link Customer}
 */
public record CustomerDtoRequest(
        @NotNull(message = "User ID is required")
        Long userId,

        @NotBlank(message = "First name is required")
        String firstName,

        @NotBlank(message = "Last name is required")
        String lastName,

        @NotBlank(message = "Email is required")
        @Email(message = "Email should be valid")
        String email,

        String phone,
        String company
) {
}