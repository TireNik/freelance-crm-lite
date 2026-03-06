package com.kika.customerservice.service;

import com.kika.customerservice.dto.CustomerDtoResponse;

import java.util.List;

public interface CustomersService {
    List<CustomerDtoResponse> getAllCustomers();
}
