package org.example.controller;

import org.example.entity.api.ExampleResponse;
import org.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ExampleController {

    ExampleService exampleService;

    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/hello")
    public ExampleResponse getExampleResponse() {
        return  new ExampleResponse(UUID.randomUUID().toString(), "hello!");
    }

    @GetMapping("/example")
    @ResponseBody
    public ExampleResponse getExampleResponse(@RequestParam String id) {
        return exampleService.getExampleResponse(Long.valueOf(id));
    }

    @GetMapping("/examples")
    @ResponseBody
    public List<ExampleResponse> listExampleResponses() {
        return exampleService.getExampleResponses();
    }

    @PostMapping("/example")
    @ResponseBody
    public ExampleResponse addExampleResponse(@RequestBody ExampleResponse newExample) {
        return exampleService.addExampleResponse(newExample);
    }

    @PutMapping("/example")
    @ResponseBody
    public ExampleResponse updateExampleResponse(@RequestParam String id, @RequestBody ExampleResponse updatedExample) {
        return exampleService.updateExampleResponse(Long.valueOf(id), updatedExample);
    }

    @DeleteMapping("/example")
    public void deleteExampleResponse(@RequestParam String id) {
         exampleService.deleteExampleResponse(Long.valueOf(id));
    }


}
