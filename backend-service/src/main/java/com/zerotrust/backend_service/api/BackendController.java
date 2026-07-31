package com.zerotrust.backend_service.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
public class BackendController {

    private final List<String> dataStore = new ArrayList<>();

    @GetMapping("/")
    public List<String> data() {
        return dataStore;
    }

    @PostMapping("/data")
    public String postData(@RequestBody String input) {
        dataStore.add(input);
        return "Successfully added!";
    }

    @GetMapping("/status")
    public String status() {
        return "Backend OK";
    }

    @PutMapping("/data/{id}")
    public String updateData(@PathVariable int id, @RequestBody String input) {
        if (id < 0 || id >= dataStore.size()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Data with id " + id + " not found");
        }

        dataStore.set(id, input);
        return "Updated item " + id;
    }

    @DeleteMapping("/data/{id}")
    public String deleteData(@PathVariable int id) {
        if (id < 0 || id >= dataStore.size()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Data with id " + id + " not found");
        }

        dataStore.remove(id);
        return "Deleted item " + id;
    }
}