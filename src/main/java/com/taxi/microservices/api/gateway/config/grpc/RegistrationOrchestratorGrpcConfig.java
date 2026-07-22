package com.taxi.microservices.api.gateway.config.grpc;

import com.taxi.microservices.contracts.registration.v1.RegistrationServiceGrpc.RegistrationServiceBlockingStub;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.ImportGrpcClients;

@Configuration
@ImportGrpcClients(
        target = "registration-orchestrator",
        types = RegistrationServiceBlockingStub.class
)
public class RegistrationOrchestratorGrpcConfig {
}
