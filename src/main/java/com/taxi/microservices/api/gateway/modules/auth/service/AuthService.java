package com.taxi.microservices.api.gateway.modules.auth.service;

import com.taxi.microservices.api.gateway.modules.auth.dto.RegistrationByPhoneRequestDto;
import com.taxi.microservices.api.gateway.modules.auth.dto.RegistrationResponseDto;
import com.taxi.microservices.api.gateway.modules.auth.mapper.AuthMapper;
import com.taxi.microservices.contracts.registration.v1.RegistrationByPhoneRequest;
import com.taxi.microservices.contracts.registration.v1.RegistrationResponse;
import com.taxi.microservices.contracts.registration.v1.RegistrationServiceGrpc.RegistrationServiceBlockingStub;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class AuthService {

    private final RegistrationServiceBlockingStub registrationServiceStub;

    private final AuthMapper authMapper;

    public RegistrationResponseDto register(RegistrationByPhoneRequestDto requestDto) {
        RegistrationByPhoneRequest request = RegistrationByPhoneRequest.newBuilder()
                .setPhoneNumber(requestDto.phoneNumber())
                .build();
        RegistrationResponse response = this.registrationServiceStub.registerByPhone(request);

        response.getRegistrationSessionId();

        return authMapper.toRegistrationResponseDto(response);
    }
}
