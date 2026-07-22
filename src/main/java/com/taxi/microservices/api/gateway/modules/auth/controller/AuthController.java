package com.taxi.microservices.api.gateway.modules.auth.controller;

import com.taxi.microservices.api.gateway.modules.auth.dto.RegistrationByPhoneRequestDto;
import com.taxi.microservices.api.gateway.modules.auth.dto.RegistrationResponseDto;
import com.taxi.microservices.api.gateway.modules.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{version}/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register/phone")
    public RegistrationResponseDto register(
            @RequestBody RegistrationByPhoneRequestDto requestDto
    ) {
        return authService.register(requestDto);
    }
}
