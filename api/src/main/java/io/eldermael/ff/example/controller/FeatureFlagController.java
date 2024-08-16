package io.eldermael.ff.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FeatureFlagController {

    @GetMapping("/")
    public Map<String, Object> index() {
        return Map.of("success", true);
    }
}
