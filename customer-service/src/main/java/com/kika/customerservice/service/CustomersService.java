package com.kika.customerservice.service;

import com.kika.customerservice.dto.CustomerDtoRequest;
import com.kika.customerservice.dto.CustomerDtoResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface CustomersService {
    List<CustomerDtoResponse> getAllCustomers();

    CustomerDtoResponse createCustomer(@Valid CustomerDtoRequest request);
}
