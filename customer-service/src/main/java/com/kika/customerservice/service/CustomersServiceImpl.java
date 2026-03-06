package com.kika.customerservice.service;

import com.kika.customerservice.dto.CustomerDtoRequest;
import com.kika.customerservice.dto.CustomerDtoResponse;
import com.kika.customerservice.entity.Customer;
import com.kika.customerservice.entity.User;
import com.kika.customerservice.mapper.CustomerMapper;
import com.kika.customerservice.repository.CustomerRepository;
import com.kika.customerservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomersServiceImpl implements CustomersService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final UserRepository userRepository;

    @Override
    public List<CustomerDtoResponse> getAllCustomers() {
        return customerMapper.toCustomerDtoResponseList(customerRepository.findAll());
    }

    @Override
    public CustomerDtoResponse createCustomer(CustomerDtoRequest request) {
         User owner = userRepository.findById(request.userId())
                 .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + request.userId()));

         Customer customer = Customer.builder()
                 .firstName(request.firstName())
                 .lastName(request.lastName())
                 .email(request.email())
                 .phone(request.phone())
                 .company(request.company())
                 .owner(owner)
                 .build();

         Customer save = customerRepository.save(customer);

         return customerMapper.toCustomerDtoResponse(save);
    }
}
