package org.example.service;

import org.example.converter.ExampleConverter;
import org.example.entity.api.ExampleResponse;
import org.example.entity.jpa.Example;
import org.example.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ExampleService {

    ExampleConverter exampleConverter;
    ExampleRepository exampleRepository;

    @Autowired
    public ExampleService(ExampleConverter exampleConverter, ExampleRepository exampleRepository) {
        this.exampleConverter = exampleConverter;
        this.exampleRepository = exampleRepository;
    }

    public ExampleResponse getExampleResponse(Long id) {
        Optional<Example> example = exampleRepository.findById(id);

        if (example.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found");
        }

        return exampleConverter.convert(example.get());
    }

    public List<ExampleResponse> getExampleResponses() {
        return exampleConverter.convert(exampleRepository.findAll());
    }

    public ExampleResponse addExampleResponse(ExampleResponse newExampleParms) {
        Example newExample = exampleRepository.save(new Example(newExampleParms.message()));

        return getExampleResponse(newExample.getId());
    }

    public ExampleResponse updateExampleResponse(Long id, ExampleResponse updatedExample) {
        Optional<Example> toUpdate = exampleRepository.findById(id);

        if (toUpdate.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found");
        }

        Example e = toUpdate.get();
        e.setMessage(updatedExample.message());
        exampleRepository.save(e);

        return getExampleResponse(e.getId());
    }

    public void deleteExampleResponse(Long id) {
        Optional<Example> toDelete = exampleRepository.findById(id);
        toDelete.ifPresent(example -> exampleRepository.delete(example));
    }
}
