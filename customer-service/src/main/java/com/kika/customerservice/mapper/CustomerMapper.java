package com.kika.customerservice.mapper;

import com.kika.customerservice.entity.Customer;
import com.kika.customerservice.dto.CustomerDtoResponse;
import com.kika.customerservice.dto.CustomerDtoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {
    CustomerDtoResponse toCustomerDtoResponse(Customer customer);

    List<CustomerDtoResponse> toCustomerDtoResponseList(List<Customer> customer);

    CustomerDtoRequest toCustomerDtoRequest(Customer customer);
}