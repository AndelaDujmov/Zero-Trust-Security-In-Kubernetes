package com.zerotrust.api_service.service;

import org.springframework.stereotype.Service;

@Service
public class ApiService {

    private final BackendClient backendClient;

    public ApiService(BackendClient backendClient) {
        this.backendClient = backendClient;
    }

    public String process() {
        return "API -> " + backendClient.getBackendData();
    }
}