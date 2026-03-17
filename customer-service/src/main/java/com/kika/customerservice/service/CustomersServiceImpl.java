package com.kika.customerservice.service;

import com.kika.customerservice.dto.CustomerDtoRequest;
import com.kika.customerservice.dto.CustomerDtoResponse;
import com.kika.customerservice.entity.Customer;
import com.kika.customerservice.entity.User;
import com.kika.customerservice.mapper.CustomerMapper;
import com.kika.customerservice.producer.KafkaProducerService;
import com.kika.customerservice.repository.CustomerRepository;
import com.kika.customerservice.repository.UserRepository;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final KafkaProducerService kafkaProducer;

    @Override
    @Transactional(readOnly = true)
    @Counted(
            value = "customer.get.all",
            description = "Count of get all customers",
            recordFailuresOnly = false
    )
    @Timed(
            value = "customer.get.all.time",
            description = "Time taken to get all customers",
            histogram = true
    )
    public List<CustomerDtoResponse> getAllCustomers() {
        return customerMapper.toCustomerDtoResponseList(customerRepository.findAll());
    }

    @Override
    @Transactional
    @Counted(
            value = "customer.created",
            description = "Count of created customers",
            recordFailuresOnly = true
    )
    @Timed(
            value = "customer.created.time",
            description = "Time taken to create a customer"
    )
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

        kafkaProducer.sendCustomerCreatedEvent(saved.getId());
        log.info("[CUSTOMER CREATED] {}", saved.getId());

        return customerMapper.toCustomerDtoResponse(saved);
    }
}
