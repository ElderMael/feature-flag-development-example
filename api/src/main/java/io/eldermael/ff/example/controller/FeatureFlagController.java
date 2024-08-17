package io.eldermael.ff.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
public class FeatureFlagController {

    @Value("${io.eldermael.ff.example.useNewBuild}")
    private boolean useNewBuild;

    @GetMapping("/")
    public Map<String, Object> index() {
        return Map.of("success", true);
    }

    @PostMapping("/submit-build")
    public BuildStatus newBuild(BuildSpec spec) {
        log.info("Build submitted, using new build: {}", useNewBuild);
        if (useNewBuild) {
            return new BuildStatus.BuildStatusBuilder().Id(UUID.randomUUID().toString()).status(Status.PENDING).build();
        }
        return new BuildStatus.BuildStatusBuilder().Id(UUID.randomUUID().toString()).status(Status.SUCCESS).build();
    }

}
