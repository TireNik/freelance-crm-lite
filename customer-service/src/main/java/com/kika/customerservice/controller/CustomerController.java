package com.kika.customerservice.controller;

import com.kika.customerservice.dto.CustomerDtoRequest;
import com.kika.customerservice.dto.CustomerDtoResponse;
import com.kika.customerservice.service.CustomersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Tag(name = "Customers", description = "CRUD для клиентов")
public class CustomerController {

    private final CustomersService customersService;

    @GetMapping
    @Operation(summary = "Получить всех клиентов")
    @Cacheable(value = "customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDtoResponse> getAllCustomers() {
        return customersService.getAllCustomers();
    }

    @PostMapping
    @Operation(summary = "Создать клиента")
    @CacheEvict(value = "customers", allEntries = true)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDtoResponse createCustomer (@Valid @RequestBody CustomerDtoRequest request) {
        return customersService.createCustomer(request);
    }
}

