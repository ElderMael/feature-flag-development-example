package io.eldermael.ff.example.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuildStatus {

    private String Id;
    private Status status;

}
