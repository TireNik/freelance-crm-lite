package com.kika.customerservice.controller;

import com.kika.customerservice.dto.CustomerDtoResponse;
import com.kika.customerservice.service.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

