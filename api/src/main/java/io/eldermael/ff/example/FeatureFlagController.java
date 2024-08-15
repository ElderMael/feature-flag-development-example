package io.eldermael.ff.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeatureFlagController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
