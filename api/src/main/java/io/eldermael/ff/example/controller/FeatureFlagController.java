package io.eldermael.ff.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeatureFlagController {

    @GetMapping("/")
    public String index() {
        return """
                {
                    "success": "ok"
                }
                """;
    }
}
