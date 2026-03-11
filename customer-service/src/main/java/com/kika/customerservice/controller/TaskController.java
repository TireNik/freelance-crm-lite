package com.kika.customerservice.controller;

import com.kika.customerservice.dto.TaskDtoResponse;
import com.kika.customerservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskDtoResponse> getAllTasks() {
        return taskService.getAll();
    }
}

