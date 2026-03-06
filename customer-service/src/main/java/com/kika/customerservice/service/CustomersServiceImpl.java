package com.kika.customerservice.service;

import com.kika.customerservice.dto.CustomerDtoResponse;
import com.kika.customerservice.mapper.CustomerMapper;
import com.kika.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomersServiceImpl implements CustomersService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDtoResponse> getAllCustomers() {
        return customerMapper.toCustomerDtoResponseList(customerRepository.findAll());
    }
}
