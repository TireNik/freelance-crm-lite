package com.kika.customerservice.dto;

import lombok.Value;

@Value
public class CustomerCreatedEvent {
    Long customerId;
}
