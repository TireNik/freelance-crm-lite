package com.kika.customerservice.service;

import com.kika.customerservice.dto.CustomerCreatedEvent;
import com.kika.customerservice.dto.CustomerDtoRequest;
import com.kika.customerservice.dto.CustomerDtoResponse;
import com.kika.customerservice.entity.Customer;
import com.kika.customerservice.entity.User;
import com.kika.customerservice.mapper.CustomerMapper;
import com.kika.customerservice.repository.CustomerRepository;
import com.kika.customerservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomersServiceImpl implements CustomersService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final UserRepository userRepository;
    private final NotificationService notificationService;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDtoResponse> getAllCustomers() {
        return customerMapper.toCustomerDtoResponseList(customerRepository.findAll());
    }

    @Override
    @Transactional
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

        Customer saved = customerRepository.save(customer);

        eventPublisher.publishEvent(new CustomerCreatedEvent(saved.getId()));

        notificationService.sendWelcomeTaskAsync(saved.getId());
        log.info("[CUSTOMER CREATED] {}", saved.getId());

        return customerMapper.toCustomerDtoResponse(saved);
    }
}
