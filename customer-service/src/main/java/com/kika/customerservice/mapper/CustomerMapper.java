package com.kika.customerservice.mapper;

import com.kika.customerservice.dto.UserDtoResponse;
import com.kika.customerservice.entity.Customer;
import com.kika.customerservice.dto.CustomerDtoResponse;
import com.kika.customerservice.dto.CustomerDtoRequest;
import com.kika.customerservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {

    List<CustomerDtoResponse> toCustomerDtoResponseList(List<Customer> customer);

    CustomerDtoRequest toCustomerDtoRequest(Customer customer);

    @Mapping(target = "owner", source = "owner", qualifiedByName = "userToUserDto")
    CustomerDtoResponse toCustomerDtoResponse(Customer customer);

    @Named("userToUserDto")
    default UserDtoResponse userToUserDto(User user) {
        if (user == null) return null;
        return new UserDtoResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt()
        );
    }
}