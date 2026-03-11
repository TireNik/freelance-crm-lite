package com.kika.customerservice.dto;

import com.kika.customerservice.entity.Customer;
import lombok.Value;

/**
 * DTO for {@link Customer}
 */
@Value
public class CustomerDto {
    Long id;
    String firstName;
    String lastName;
}