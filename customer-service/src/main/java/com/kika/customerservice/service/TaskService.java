package com.kika.customerservice.service;

import com.kika.customerservice.dto.TaskDtoResponse;
import com.kika.customerservice.entity.Customer;

import java.util.List;

public interface TaskService {
    TaskDtoResponse createdWelcomeTask(Customer customer);

    List<TaskDtoResponse> getAll();
}
