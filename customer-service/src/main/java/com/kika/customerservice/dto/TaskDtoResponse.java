package com.kika.customerservice.dto;

import com.kika.customerservice.entity.TaskStatus;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.kika.customerservice.entity.Task}
 */
@Value
public class TaskDtoResponse {
    Long id;
    String title;
    String description;
    TaskStatus status;
    CustomerDto customer;
    UserDto user;
    LocalDateTime dueDate;
    LocalDateTime createdAt;
}