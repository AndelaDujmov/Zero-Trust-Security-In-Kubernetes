package com.zerotrust.api_service.api;

import org.springframework.web.bind.annotation.*;
import com.zerotrust.api_service.service.ApiService;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private final ApiService service;

    public ApiController(ApiService service) {
        this.service = service;
    }

    @GetMapping("/data")
    public String getData() {
        return service.process();
    }
}