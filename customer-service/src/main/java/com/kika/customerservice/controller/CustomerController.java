package com.kika.customerservice.controller;

import com.kika.customerservice.dto.CustomerDtoRequest;
import com.kika.customerservice.dto.CustomerDtoResponse;
import com.kika.customerservice.service.CustomersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomersService customersService;

    @GetMapping
    public ResponseEntity<List<CustomerDtoResponse>> getAllCustomers() {
        List<CustomerDtoResponse> customers = customersService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDtoResponse createCustomer (@Valid @RequestBody CustomerDtoRequest request) {
        return customersService.createCustomer(request);
    }
}

