package com.kika.customerservice.mapper;

import com.kika.customerservice.entity.User;
import com.kika.customerservice.dto.UserDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserDtoResponse toUserDtoResponse(User user);
}