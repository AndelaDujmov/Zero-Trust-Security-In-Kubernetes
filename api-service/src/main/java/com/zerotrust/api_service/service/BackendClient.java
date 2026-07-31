package com.zerotrust.api_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
    
    public String getStatus() {
        return restTemplate.getForObject(backendUrl + "/status", String.class);
    }

    public String postData(String input) {
        return restTemplate.postForObject(
            backendUrl + "/data",
            input,
            String.class
        );
    }

     public String updateData(int id, String input) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        HttpEntity<String> entity = new HttpEntity<>(input, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                backendUrl + "/data/" + id,
                HttpMethod.PUT,
                entity,
                String.class
        );

        return response.getBody();
    }

    public String deleteData(int id) {
        ResponseEntity<String> response = restTemplate.exchange(
                backendUrl + "/data/" + id,
                HttpMethod.DELETE,
                null,
                String.class
        );

        return response.getBody();
    }
}