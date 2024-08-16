package io.eldermael.ff.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class FeatureFlagController {

    @GetMapping("/")
    public Map<String, Object> index() {
        return Map.of("success", true);
    }

    @PostMapping("/submit-build")
    public BuildStatus newBuild(BuildSpec spec) {
        return new BuildStatus.BuildStatusBuilder()
                .Id(UUID.randomUUID().toString())
                .status(Status.SUCCESS)
                .build();
    }

    @PostMapping("/submit-build-with-new-experience")
    public BuildStatus newBuildExperience(BuildSpec spec) {
        return new BuildStatus.BuildStatusBuilder()
                .Id(UUID.randomUUID().toString())
                .status(Status.PENDING)
                .build();
    }
}
