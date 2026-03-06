package com.kika.customerservice.mapper;

import com.kika.customerservice.entity.Customer;
import com.kika.customerservice.dto.CustomerDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {
    List<CustomerDtoResponse> toCustomerDtoResponseList(List<Customer> customer);
}