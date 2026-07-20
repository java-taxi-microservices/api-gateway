package com.taxi.microservices.api.gateway.config.web;

public class ApiVersionParser implements org.springframework.web.accept.ApiVersionParser {

    @Override
    public Comparable parseVersion(String version) {
        if(version.startsWith("v")) {
            version = version.substring(1);
        }

        return version;
    }
}
