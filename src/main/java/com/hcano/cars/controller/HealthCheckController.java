package com.hcano.cars.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(HealthCheckController.URL)
public class HealthCheckController {
    public static final String URL = "/health-check";

    @GetMapping
    public Map<String, String> index() {
        HashMap<String, String> status = new HashMap<>();
        status.put("status", "ok");
        return status;
    }
}
