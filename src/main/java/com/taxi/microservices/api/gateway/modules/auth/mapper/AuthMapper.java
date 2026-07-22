package com.taxi.microservices.api.gateway.modules.auth.mapper;

import com.taxi.microservices.api.gateway.modules.auth.dto.RegistrationResponseDto;
import com.taxi.microservices.contracts.registration.v1.RegistrationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface AuthMapper {

    RegistrationResponseDto toRegistrationResponseDto(RegistrationResponse response);
}
