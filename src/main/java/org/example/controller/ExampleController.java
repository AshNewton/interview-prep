package org.example.controller;

import org.example.entity.api.ExampleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ExampleController {

    @GetMapping("/hello")
    public ExampleResponse getExampleResponse() {
        return new ExampleResponse(UUID.randomUUID().toString(), "hello!");
    }


}
