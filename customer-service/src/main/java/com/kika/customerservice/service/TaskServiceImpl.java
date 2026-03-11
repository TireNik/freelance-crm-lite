package com.kika.customerservice.service;

import com.kika.customerservice.dto.TaskDtoResponse;
import com.kika.customerservice.entity.Customer;
import com.kika.customerservice.entity.Task;
import com.kika.customerservice.entity.TaskStatus;
import com.kika.customerservice.mapper.TaskMapper;
import com.kika.customerservice.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepo;
    private final TaskMapper taskMap;

    @Override
    @Transactional(readOnly = true)
    public List<TaskDtoResponse> getAll() {
        return taskMap.toTaskDtoResponsesList(taskRepo.findAll());
    }

    @Override
    @Transactional
    public TaskDtoResponse createdWelcomeTask(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is null");
        }

        Task task = Task.builder()
                .title("Позвонить клиенту " + customer.getFirstName())
                .customer(customer)
                .user(customer.getOwner())
                .status(TaskStatus.NEW)
                .build();

        Task saved = taskRepo.save(task);

        return taskMap.toTaskDtoResponse(saved);
    }
}
