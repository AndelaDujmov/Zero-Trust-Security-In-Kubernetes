package com.zerotrust.backend_service.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BackendController {

    private final List<String> dataStore = new ArrayList<>();

    @GetMapping("/data")
    public String data() {
        return "Hello from backend";
    }

    @PostMapping("/data")
    public String postData(String input) {
        dataStore.add(input);
        return "Hello from backend";
    }

    @GetMapping("/status")
    public String status() {
        return "Backend OK";
    }
}