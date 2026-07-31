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

    public String getStatus() {
        return "API → " + backendClient.getStatus();
    }

    public String sendData(String input) {
        return "API → stored: " + backendClient.postData(input);
    }

    public String updateData(int id, String input) {
        return "API → stored: " + backendClient.updateData(id, input);
    }

    public String deleteData(int id) {
        return "API → stored: " + backendClient.deleteData(id);
    }
}