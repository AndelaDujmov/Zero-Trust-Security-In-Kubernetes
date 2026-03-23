package com.zerotrust.backend_service.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BackendController {

    @GetMapping("/data")
    public String data() {
        return "Hello from backend";
    }

    @GetMapping("/status")
    public String status() {
        return "Backend OK";
    }

    @GetMapping("/info")
    public String info() {
        return "Backend v1.0";
    }
}