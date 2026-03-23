package com.zerotrust.api_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BackendClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${backend.url}")
    private String backendUrl;

    public String getBackendData() {
        return restTemplate.getForObject(
            backendUrl,
            String.class
        );
    }
}