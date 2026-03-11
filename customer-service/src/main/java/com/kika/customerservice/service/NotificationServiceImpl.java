package com.kika.customerservice.service;

import com.kika.customerservice.entity.Customer;
import com.kika.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

    private final TaskService task;
    private final CustomerRepository customerRepo;

    @Override
    @Transactional(readOnly = true)
    public void sendWelcomeTaskAsync(Long customerId) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        task.createdWelcomeTask(customer);
    }
}
