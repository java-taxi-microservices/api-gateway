package com.taxi.microservices.api.gateway.modules.hello.controller;

import com.taxi.microservices.api.gateway.modules.hello.dto.HelloDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

    @GetMapping(path = "/{version}/hello")
    public HelloDto HelloDto() {
        return new HelloDto("Hello");
    }
}
