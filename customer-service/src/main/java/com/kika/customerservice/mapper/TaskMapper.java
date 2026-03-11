package com.kika.customerservice.mapper;

import com.kika.customerservice.dto.CustomerDtoResponse;
import com.kika.customerservice.dto.TaskDtoResponse;
import com.kika.customerservice.dto.UserDtoResponse;
import com.kika.customerservice.entity.Customer;
import com.kika.customerservice.entity.Task;
import com.kika.customerservice.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    List<TaskDtoResponse> toTaskDtoResponsesList(List<Task> tasks);

    CustomerDtoResponse toCustomerDto(Customer customer);

    UserDtoResponse toUserDto(User user);

    @Mapping(target = "customer", source = "customer")
    @Mapping(target = "user", source = "user")
    TaskDtoResponse toTaskDtoResponse(Task task);
}